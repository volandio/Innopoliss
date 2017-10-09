package September2017.Date_28_09_17.proxies;

public interface IDataDownloader {
    void download(String url);
    String getFileContent(String url, int fileSize);
    void log();
}
