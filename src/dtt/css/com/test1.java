package dtt.css.com;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class test1 {

	public static void main(String[] args) {
//		初始化
		ActiveXComponent com = new ActiveXComponent("clsid:6D2088B7-1B97-4960-9535-5115614F29E0") ;
		Dispatch disp = com.getObject();
//LONG ReadCard(LONG nPort, LPCTSTR szPhotoPath)
//		调用无参的方法，并返回一个short值
		
		String a1="1001";
		String a2="F:\\";
		long  ReadCard = Dispatch.call(disp,"ReadCard").getInt();
		System.out.println("初始化结果为"+ReadCard);
//		Dispatch.call(disp, "Init").getShort();
//		调用有一个参数的方法，并返回一个boolean值
//		Dispatch.call(disp,"Method",new Variant(args)).getBoolean();
		
	}

}
