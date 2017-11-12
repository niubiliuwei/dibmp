package cn.mldn.mldnfdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

public class FileDeleteDemo { 
	public static void main(String[] args) throws Exception {
		// 通过ClassPath路径获取要使用的配置文件，实现了资源的定位
		ClassPathResource classPathResource = new ClassPathResource("fastdfs.properties");
		// 进行客户端访问的整体配置，需要知道配置文件的完整路径
		ClientGlobal.init(classPathResource.getClassLoader().getResource("fastdfs.properties").getPath());
		// FastDFS的核心操作在于tracker处理上，所以此时需要定义Tracker客户端
		TrackerClient trackerClient = new TrackerClient();
		// 定义TrackerServer的配置信息
		TrackerServer trackerServer = trackerClient.getConnection();
		// 在整个FastDFS之中真正负责干活的就是Storage
		StorageServer storageServer = null;
		StorageClient1 storageClient = new StorageClient1(trackerServer, storageServer);
		int len = storageClient.delete_file1("group2/M00/00/00/wKhElVn8AhKAXL_FAAC_s9JKjxg523.jpg") ;
		System.err.println(len);
		trackerServer.close(); 
	} 
}
