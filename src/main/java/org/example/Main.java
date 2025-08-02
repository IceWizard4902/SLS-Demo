package org.example;

import com.aliyun.openservices.log.Client;
import com.aliyun.openservices.log.common.LogItem;
import com.aliyun.openservices.log.exception.LogException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws LogException {
        // The sample project configuration
        String project = "stored-xss-demo";
        String logstore = "stored-xss-demo";
        String endpoint = "ap-southeast-1.log.aliyuncs.com";

        // AKSK should have AliyunLogFullAccess
        String accessKeyId = "YOUR ACCESS KEY ID";
        String accessKeySecret = "YOUR ACCESS KEY SECRET";

        Client client = new Client(endpoint, accessKeyId, accessKeySecret);
        List<LogItem> logs = new ArrayList<>();
        LogItem logItem = new LogItem((int) (new Date().getTime() / 1000));
        logItem.PushBack("sample_field", "sample_value");
        logs.add(logItem);

        client.PutLogs(project, logstore, "", logs, "");
    }
}