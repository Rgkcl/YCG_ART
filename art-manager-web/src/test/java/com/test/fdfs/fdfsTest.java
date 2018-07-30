package com.test.fdfs;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

public class fdfsTest {
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	@Test
	public void TestFDFS()
	{System.out.println(IMAGE_SERVER_URL);
		
			try {
				//1.加载配置文件
				ClientGlobal.init("D:/ART_YCG/YCG_ART/art-manager-web/src/main/resources/resource/client.conf");
				//2.创建对象
				TrackerClient trackerclient = new TrackerClient();
				//3创建对象
				TrackerServer trackerserver = trackerclient.getConnection();
				//4.创建StorageServer
				StorageServer storageserver = null;
				//5.创建StorageClient
				StorageClient storageclient = new StorageClient(trackerserver,null);
				
				String[] strings = storageclient.upload_file("C:/Users/17284/Desktop/2.jpg", "jpg", null);
				for (String string : strings) {
					System.out.println(string);
					
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//2.创建
	}
}
