package iisi.example.gia.batchconfig;

import org.springframework.batch.core.JobExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/batch")
public class BatchController {

    @Autowired
    private BatchService batchService;

    @PostMapping("exportEmp")
    public ResponseEntity<String> exportEmp(){
        // 確保有這個目錄
        try{
            File exportDir = new File(BatchConstants.EXPORT_PATH);

            if(!exportDir.exists()){
                exportDir.mkdirs();
            }

            JobExecution execution = batchService.exportJob();

            return ResponseEntity.ok("Job 執行狀態: " + execution.getStatus());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("執行失敗:" + e.getMessage());
        }
    }
}
