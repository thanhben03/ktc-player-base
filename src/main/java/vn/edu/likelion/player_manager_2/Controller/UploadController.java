package vn.edu.likelion.player_manager_2.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.edu.likelion.player_manager_2.Service.UploadService;

import java.io.IOException;

@RestController
@RequestMapping("/api/upload")
@CrossOrigin
public class UploadController {
    private final UploadService cloudinaryService;

    public UploadController(UploadService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }

    @PostMapping("/image")
    public ResponseEntity<?> uploadImage(@RequestPart("file") MultipartFile file,
                                         @RequestParam("folder") String folderName) throws IOException {
        return ResponseEntity.ok(cloudinaryService.uploadFile(file, folderName));
    }
}