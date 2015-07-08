package dr.yadcf.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dr.yadcf.common.TableAaData;
import dr.yadcf.db.objectify.EntryDb;

public class EntrysTableSource extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4219756235170784173L;

	private static final Logger log = Logger.getLogger(EntrysTableSource.class.getName());
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<EntryDb> entrys = populateList();
		

		TableAaData bookamrkAaData = null;
		List<List<String>> aaData =  new ArrayList<List<String>>();
		
		List<String> rowData = null;
		for (EntryDb EntryDb : entrys) {
			rowData = new ArrayList<String>();
			rowData.add(EntryDb.getEngine());
			rowData.add(EntryDb.getBrowser());
			rowData.add(EntryDb.getPlatform());
			rowData.add(EntryDb.getVersion());
			rowData.add(EntryDb.getGrade());
			
			aaData.add(rowData);
		}
		
		bookamrkAaData = new TableAaData(aaData);
		
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		log.info("Return value to Entrys table:\t"+ new Gson().toJson(bookamrkAaData));
		resp.getWriter().write(new Gson().toJson(bookamrkAaData));

	        
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("post");
		doGet(req,resp);
	}


	private List<EntryDb> populateList(){
		List<EntryDb> retList = new ArrayList<EntryDb>();
		
		retList.add(new EntryDb("Trident","Internet Explorer 4.0","Win 95+","4","X"));
		retList.add(new EntryDb("Trident","Internet Explorer 5.0","Win 95+","5","C"));
		retList.add(new EntryDb("Trident","Internet Explorer 5.5","Win 95+","5.5","A"));
		retList.add(new EntryDb("Trident","Internet Explorer 6","Win 98+","6","A"));
		retList.add(new EntryDb("Trident","Internet Explorer 7","Win XP SP2+","7","A"));
		retList.add(new EntryDb("Trident","AOL browser (AOL desktop)","Win XP","6","A"));
		retList.add(new EntryDb("Gecko","Firefox 1.0","Win 98+ / OSX.2+","1.7","A"));
		retList.add(new EntryDb("Gecko","Firefox 1.5","Win 98+ / OSX.2+","1.8","A"));
		retList.add(new EntryDb("Gecko","Firefox 2.0","Win 98+ / OSX.2+","1.8","A"));
		retList.add(new EntryDb("Gecko","Firefox 3.0","Win 2k+ / OSX.3+","1.9","A"));
		retList.add(new EntryDb("Gecko","Camino 1.0","OSX.2+","1.8","A"));
		retList.add(new EntryDb("Gecko","Camino 1.5","OSX.3+","1.8","A"));
		retList.add(new EntryDb("Gecko","Netscape 7.2","Win 95+ / Mac OS 8.6-9.2","1.7","A"));
		retList.add(new EntryDb("Gecko","Netscape Browser 8","Win 98SE+","1.7","A"));
		retList.add(new EntryDb("Gecko","Netscape Navigator 9","Win 98+ / OSX.2+","1.8","A"));
		retList.add(new EntryDb("Gecko","Mozilla 1.0","Win 95+ / OSX.1+","1","A"));
		retList.add(new EntryDb("Gecko","Mozilla 1.1","Win 95+ / OSX.1+","1.1","A"));
		retList.add(new EntryDb("Gecko","Mozilla 1.2","Win 95+ / OSX.1+","1.2","A"));
		retList.add(new EntryDb("Gecko","Mozilla 1.3","Win 95+ / OSX.1+","1.3","A"));
		retList.add(new EntryDb("Gecko","Mozilla 1.4","Win 95+ / OSX.1+","1.4","A"));
		retList.add(new EntryDb("Gecko","Mozilla 1.5","Win 95+ / OSX.1+","1.5","A"));
		retList.add(new EntryDb("Gecko","Mozilla 1.6","Win 95+ / OSX.1+","1.6","A"));
		retList.add(new EntryDb("Gecko","Mozilla 1.7","Win 98+ / OSX.1+","1.7","A"));
		retList.add(new EntryDb("Gecko","Mozilla 1.8","Win 98+ / OSX.1+","1.8","A"));
		retList.add(new EntryDb("Gecko","Seamonkey 1.1","Win 98+ / OSX.2+","1.8","A"));
		retList.add(new EntryDb("Gecko","Epiphany 2.20","Gnome","1.8","A"));
		retList.add(new EntryDb("Webkit","Safari 1.2","OSX.3","1.25","A"));
		retList.add(new EntryDb("Webkit","Safari 1.3","OSX.3","3.12","A"));
		retList.add(new EntryDb("Webkit","Safari 2.0","OSX.4+","4.19","A"));
		retList.add(new EntryDb("Webkit","Safari 3.0","OSX.4+","5.22","A"));
		retList.add(new EntryDb("Webkit","OmniWeb 5.5","OSX.4+","4.20","A"));
		retList.add(new EntryDb("Webkit","iPod Touch / iPhone","iPod","4.20","A"));
		retList.add(new EntryDb("Webkit","S60","S60","4.13","A"));
		retList.add(new EntryDb("Presto","Opera 7.0","Win 95+ / OSX.1+","-","A"));
		retList.add(new EntryDb("Presto","Opera 7.5","Win 95+ / OSX.2+","-","A"));
		retList.add(new EntryDb("Presto","Opera 8.0","Win 95+ / OSX.2+","-","A"));
		retList.add(new EntryDb("Presto","Opera 8.5","Win 95+ / OSX.2+","-","A"));
		retList.add(new EntryDb("Presto","Opera 9.0","Win 95+ / OSX.3+","-","A"));
		retList.add(new EntryDb("Presto","Opera 9.2","Win 88+ / OSX.3+","-","A"));
		retList.add(new EntryDb("Presto","Opera 9.5","Win 88+ / OSX.3+","-","A"));
		retList.add(new EntryDb("Presto","Opera for Wii","Wii","-","A"));
		retList.add(new EntryDb("Presto","Nokia N800","N800","-","A"));
		retList.add(new EntryDb("Presto","Nintendo DS browser","Nintendo DS","8.5","C/A1"));
		retList.add(new EntryDb("KHTML","Konqureror 3.1","KDE 3.1","3.1","C"));
		retList.add(new EntryDb("KHTML","Konqureror 3.3","KDE 3.3","3.3","A"));
		retList.add(new EntryDb("KHTML","Konqureror 3.5","KDE 3.5","3.5","A"));
		retList.add(new EntryDb("Tasman","Internet Explorer 4.5","Mac OS 8-9","-","X"));
		retList.add(new EntryDb("Tasman","Internet Explorer 5.1","Mac OS 7.6-9","1","C"));
		retList.add(new EntryDb("Tasman","Internet Explorer 5.2","Mac OS 8-X","1","C"));
		retList.add(new EntryDb("Misc","NetFront 3.1","Embedded devices","-","C"));
		retList.add(new EntryDb("Misc","NetFront 3.4","Embedded devices","-","A"));
		retList.add(new EntryDb("Misc","Dillo 0.8","Embedded devices","-","X"));
		retList.add(new EntryDb("Misc","Links","Text only","-","X"));
		retList.add(new EntryDb("Misc","Lynx","Text only","-","X"));
		retList.add(new EntryDb("Misc","IE Mobile","Windows Mobile 6","-","C"));
		retList.add(new EntryDb("Misc","PSP browser","PSP","-","C"));
		retList.add(new EntryDb("Other browsers","All others","-","-","U"));
	
		
		return retList;
	}
	
	
}
