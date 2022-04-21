package com.EBanking.Qa.Util;

import java.io.File;
import java.util.List;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;

public class ExcelPiji {

	public static String cname;
	public static String addres;
	public static String city;
	public static String state;
	public static long pinc;
	public static long mobile;
	public static String email;
	public static String pword;

	

		PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings().sheetName("New Customer").build();
		List<NewCustomerPoiji> nc = Poiji.fromExcel(new File("Ebanking_poiji.xls"), NewCustomerPoiji.class, options);
		{
		cname = nc.get(1).getCname();
		addres = nc.get(1).getAddres();
		city = nc.get(1).getCity();
		state = nc.get(1).getState();
		pinc = nc.get(1).getPin();
		mobile = nc.get(1).getMobileno();
		email = nc.get(1).getEmail();
		pword = nc.get(1).getPword();

		System.out.println(cname + addres + city + state + pinc + mobile + email + pword);

	}
}