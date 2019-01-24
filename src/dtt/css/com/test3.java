package dtt.css.com;

import javax.swing.JOptionPane;
public class test3
{		
	public static void main(String[] args)
	{
		JOptionPane.showMessageDialog(null,
				"等待调试!", "系统信息", JOptionPane.INFORMATION_MESSAGE);
		//----读身份证测试
		String path = id100sdk.getPath();
		if(id100sdk.InitCommExt() <= 0)
		{
			System.out.println("InitCommExt fail\n");
			return;
		}
		System.out.println("InitCommExt succ\n");
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(id100sdk.Authenticate() != 1)
			{
				System.out.println("Authenticate fail\n");
				return;
			}
			System.out.println("Authenticate succ\n");
			//循环读取
			long tickStart = System.currentTimeMillis();
			int ret = 0;
			while((ret=id100sdk.ReadContent(1)) != 1 && System.currentTimeMillis() < 2000)
			{
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ret != 1)
			{
				System.out.println("ReadContent fail\n");
				return;
			}
			
			System.out.println("ReadContent succ\n");
			System.out.println("输出文件路径：" + path + "\n");
			System.out.println("GetBmpPhotoExt ret=" + id100sdk.GetBmpPhotoExt());
			System.out.println("\n");
			System.out.println("姓名=%s\n"+ id100sdk.getName());
			System.out.println("民族=%s\n"+ id100sdk.getNation());
			System.out.println("性别=%s\n"+ id100sdk.getSex());
			System.out.println("身份证号=%s\n"+ id100sdk.getIDNum());
			System.out.println("出生日期=%s\n"+ id100sdk.getBirthdate());
			System.out.println("常住地址=%s\n"+ id100sdk.getAddress());
			System.out.println("签发机关=%s\n"+ id100sdk.getIssue());
			System.out.println("有效期=%s-%s\n"+ id100sdk.getEffectedDate()+id100sdk.getExpireDate());
			//System.out.println("bmp base64头像=%s\n", id100sdk.getBMPPhotoBase64());
			//System.out.println("jpg base64头像=%s\n", id100sdk.getJPGPhotoBase64());
			
		}
		
		//读身份证测试结束
		/*
		//IC卡测试
		int nPort = 8;	//串口号
		System.out.println("发卡器版本:"+ id100sdk.ICGetDevVersion(nPort));
		
		int snr[] = new int[1];
		if (1 == id100sdk.ICGetICSnr(nPort, snr))
		{
			System.out.println("读取IC卡卡号成功,卡号为"+ snr[0]);
		}
		else
		{
			System.out.println("读取IC卡卡号失败");
		}
		System.out.println("身份证物理卡号"+ id100sdk.ICGetIDSnr(nPort));
		System.out.println("读IC卡数据："+ id100sdk.ICReadData(nPort, 0, 2, 0, "FFFFFFFFFFFF", snr));
		if(1 == id100sdk.ICWriteData(nPort, 0, 2, 0, "FFFFFFFFFFFF", "EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE", snr))
		{
			System.out.println("写卡成功");
		}
		else
		{
			System.out.println("写卡失败");
		}
		
		//HID 语音测试
		id100sdk.HIDVoice(0);
		*/
	}
}
