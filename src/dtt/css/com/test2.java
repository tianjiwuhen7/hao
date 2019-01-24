package dtt.css.com;

import org.jawin.COMException;
import org.jawin.FuncPtr;
import org.jawin.ReturnFlags;

public class test2 {

	public static void main(String[] args) {
		FuncPtr test1 = null;
		int result=-1;
		try {
		test1 = new FuncPtr("WidControl.ocx", "ReadCard");//第一个为dll文件（把Dll文件放在当前目录下） 第一个参数为函数名
		result=test1.invoke_I(1001,"", ReturnFlags.CHECK_NONE);//传入参数
		System.err.println("---------------"+result);
		} catch (COMException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}

}
