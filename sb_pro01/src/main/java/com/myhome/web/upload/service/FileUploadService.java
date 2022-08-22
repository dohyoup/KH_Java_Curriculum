package com.myhome.web.upload.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.myhome.web.upload.model.FileUploadDAO;
import com.myhome.web.upload.model.FileUploadDTO;

@Service
public class FileUploadService {
	

	@Autowired
	private FileUploadDAO dao;
	
	@Transactional	// 파일 데이터는 MultipartFile 객체나 @RequestParam 어노테이션을 이용해서 전달받을 수 있다
	public int upload(MultipartFile file, FileUploadDTO data) throws Exception {
		//파일 저장을 위한  file객체생성
		File folder = new File(data.getLocation()); // data.getLocation()위치에 저장을 위한 file 객체 생성
		if(!folder.exists()) {//저장할 폴더가 존재하지 않으면
			folder.mkdirs(); //디렉토리 생성
		}
		
		UUID uuid = UUID.nameUUIDFromBytes(file.getBytes());
		
		data.setFileName(file.getOriginalFilename());//실제 파일이름
		data.setUuidName(uuid.toString());
		data.setFileSize((int)file.getSize());//파일 크기
		data.setContentType(file.getContentType());//파일 타입
		                 //파일 저장위치 + 구분자 + 파일 실제이름
		
		int count = dao.getCount(data.getbId());//로그인한 아이디로 업로드한 파일 갯수
		
		if(count >= 3) {//3개 넘어가면
			// 업로드 수량 초과.
			return -1;
		}
		
		boolean result = dao.insertData(data);//파일데이터 DB에 저장
		if(result) {//저장 성공하면
			try {
				file.transferTo(new File(data.getLocation() + File.separatorChar + data.getUuidName())); //업로드 파일 지정위치 폴더에 저장작업
				return 1;
			} catch (IOException e) {
				throw new Exception("서버에 파일 업로드를 실패하였습니다.");
			}
		} else {
			// 업로드 실패
			return 0;
		}
	}

	public List<FileUploadDTO> getDatas(int bId) {
		List<FileUploadDTO> datas = dao.selectDatas(bId);
		return datas;
	}
	
}
