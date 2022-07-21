package locs.service;

import java.util.ArrayList;
import java.util.List;

import dept.model.DeptDAO;
import dept.model.DeptDTO;
import locs.model.LocsDAO;
import locs.model.LocsDTO;

public class LocsService {

	private LocsDAO dao;
	
	public LocsService() {
		dao = new LocsDAO();
	}
	
	public List<LocsDTO> getAll() {
		List<LocsDTO> datas = dao.searchAll();
		return datas;
	}
	
	public LocsDTO getLocsId(String id) {
		int locsId = Integer.parseInt(id);
		return _getLocsId(locsId);
	}
	
	public LocsDTO getLocsId(int id) {
		return _getLocsId(id);
	}
	
	private LocsDTO _getLocsId(int id) {
		LocsDTO data = dao.serachLocsId(id);
		return data;
	}
	
	public List<LocsDTO> getPage(int pageNumber) {
		int start = (pageNumber - 1) * 10 + 1;
		int end = start + 9;
		
		dao = new LocsDAO();
		List<LocsDTO> datas = dao.searchPage(start, end);
		dao.close();
		return datas;
	}
	
	public List<LocsDTO> getPage(int pageNumber, int count) {
		int start = (pageNumber - 1) * count + 1;
		int end = start + count - 1;
		
		dao = new LocsDAO();
		List<LocsDTO> datas = dao.searchPage(start, end);
		dao.close();
		return datas;
	}
	
	public List<LocsDTO> getPage(int pageNumber, int count, String sort) {
		int start = (pageNumber - 1) * count + 1;
		int end = start + count - 1;
		
		dao = new LocsDAO();
		List<LocsDTO> datas = dao.searchPage(start, end, sort);
		dao.close();
		return datas;
	}
	
	public List<Integer> getPageNumberList() {
		dao = new LocsDAO();
		int rowCount = dao.rowCount();
		dao.close();
		// 여기에 페이지 번호를 가지는 리스트를 만든다.
		List<Integer> pageList = new ArrayList<Integer>();
		int pageNum = (rowCount - 1) / 10;
		for(int n = 0; n <= pageNum; n++) {
			pageList.add(n + 1);
		}
		return pageList;
	}
	
	public List<Integer> getPageNumberList(int count) {
		dao = new LocsDAO();
		int rowCount = dao.rowCount();
		dao.close();
		// 여기에 페이지 번호를 가지는 리스트를 만든다.
		List<Integer> pageList = new ArrayList<Integer>();
		int pageNum = (rowCount - 1) / count;
		for(int n = 0; n <= pageNum; n++) {
			pageList.add(n + 1);
		}
		return pageList;
	}
}
