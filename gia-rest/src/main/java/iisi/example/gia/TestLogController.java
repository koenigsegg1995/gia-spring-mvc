package iisi.example.gia;

import iisi.example.gia.batchconfig.BatchConstants;
import jakarta.servlet.ServletContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestLogController {

    @Autowired
    private ServletContext servletContext;

    @GetMapping("log")
    public String testLog(){
        File logDir = new File(servletContext.getRealPath("/WEB-INF/logs"));

        if(!logDir.exists()){
            logDir.mkdirs();
        }

        log.debug("這是 DEBUG 日誌");
        log.info("這是 INFO 日誌");
        log.warn("這是 WARN 日誌");
        log.error("這是 ERROR 日誌");

        try{
            int result = 1 / 0;
        }catch(Exception e){
            log.error("發生異常!", e);
        }

        return "日誌測試完成";
    }
}
