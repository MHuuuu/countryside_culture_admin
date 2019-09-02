package com.countryside_culture.admin.demo.controller;

import com.countryside_culture.admin.demo.entity.Chunk;
import com.countryside_culture.admin.demo.entity.FileInfo;
import com.countryside_culture.admin.demo.entity.Result;
import com.countryside_culture.admin.demo.service.ChunkService;
import com.countryside_culture.admin.demo.service.FileInfoService;
import com.countryside_culture.admin.demo.util.FileUtils;
import com.countryside_culture.admin.demo.util.ResultUtil;
import com.countryside_culture.admin.demo.entity.UploadFileEntity;
import com.countryside_culture.admin.demo.util.UploadKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static com.countryside_culture.admin.demo.util.FileUtils.generatePath;
import static com.countryside_culture.admin.demo.util.FileUtils.merge;

@RestController
@RequestMapping("/public")
public class PublicController {
    // logback
    private final static Logger log = LoggerFactory.getLogger(PublicController.class);
    //    final String IMG_PATH="assets\\images\\";
    //    final String PARENT_PATH="C:\\Users\\mercer97\\Desktop\\upload\\";
    @Value("${prop.upload-folder}")
    private String PARENT_PATH;
    @Value("${prop.img-path}")
    private String IMG_PATH;
    @Value("${prop.video-path}")
    private String VIDEO_PATH;
    @Value("${prop.online-url}")
    private String ONLINE_URL;


    // 图片视频上传
    @PostMapping(value = "/uploadImg")
    public Result upload(HttpServletRequest request,@RequestParam MultipartFile file){
        String pPath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        // System.out.println("z:pPath"+pPath);
        UploadFileEntity uploadFileEntity=UploadKit.getFile(request,IMG_PATH,true);
        Map<String,String> map=new HashMap<>();
        map.put("url",ONLINE_URL+uploadFileEntity.getServerPath());
        return ResultUtil.success(map);
    }

    @Resource
    private FileInfoService fileInfoService;
    @Resource
    private ChunkService chunkService;
    @PostMapping("/chunk")
    public Result uploadChunk(Chunk chunk) {
        MultipartFile file = chunk.getFile();
        log.debug("file originName: {}, chunkNumber: {}", file.getOriginalFilename(), chunk.getChunkNumber());

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(generatePath(PARENT_PATH+VIDEO_PATH, chunk));
            //文件写入指定路径
            Files.write(path, bytes);
            log.debug("文件 {} 写入成功, uuid:{}", chunk.getFilename(), chunk.getIdentifier());
            chunkService.saveChunk(chunk);

            //"文件上传成功"
            return ResultUtil.success();
        } catch (IOException e) {
            e.printStackTrace();
            // "后端异常...";
            return ResultUtil.error(2333,"后端异常...");
        }
    }

    @GetMapping("/chunk")
    public Object checkChunk(Chunk chunk, HttpServletResponse response) {
        if (chunkService.checkChunk(chunk.getIdentifier(), chunk.getChunkNumber())) {
            response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
        }

        return chunk;
    }

    @PostMapping("/mergeFile")
    public Result mergeFile(@RequestBody FileInfo fileInfo) {
        String filename = fileInfo.getFilename();
        String file = PARENT_PATH+VIDEO_PATH  + fileInfo.getIdentifier() + "/" + filename;
        String folder = PARENT_PATH+VIDEO_PATH  + fileInfo.getIdentifier();
        merge(file, folder, filename);

        String location = VIDEO_PATH  + fileInfo.getIdentifier() + "/" + filename;
        fileInfo.setLocation(location);
        fileInfoService.addFileInfo(fileInfo);
        // "合并成功"
        return ResultUtil.success(fileInfo.getLocation());
    }
}

