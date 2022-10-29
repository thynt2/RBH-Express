package common;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class GlobalConstants {
    private static GlobalConstants globalInstance;

    private GlobalConstants() {

    }

    public static synchronized GlobalConstants getGlobalConstants() {
        if (globalInstance == null) {
            globalInstance = new GlobalConstants();
        }
        return globalInstance;
    }

    public final long longTimeout = 30;
    private final long shotTimeout = 5;
    private final String projectPath = System.getProperty("user.dir");
    private final String osName = System.getProperty("os.name");
    private final String uploadFilePath = projectPath + File.separator + "uploadFiles" + File.separator;
    private final String downloadFilePath = projectPath + File.separator + "downloadFiles" + File.separator;
    private final String url = "https://demotrxsb.y3technologies.com/signin";
    private final int implicitWaitTimeout = 15;

}
