package job.service;

import java.util.List;

import common.model.AbstractService;
import job.model.JobDAO;
import job.model.JobDTO;

public class JobService extends AbstractService {
	
	@Override
	public List<JobDTO> getAll(){
		JobDAO dao = new JobDAO();
		List<JobDTO> datas = dao.selectAll();
		dao.close();
		return datas;	
	}

	@Override
	public Object getId(Object o) {
		JobDTO dto = (JobDTO)o; //다운캐스팅
		JobDAO dao = new JobDAO();
		JobDTO data = dao.selectId(dto.getJobId());
		dao.close();
		return data;
	}

	@Override
	public Object getId(int i) {
		JobDAO dao = new JobDAO();
		JobDTO data = dao.selectId(i);
		dao.close();
		return data;
	}

	@Override
	public boolean add(Object o) {
		JobDTO dto = (JobDTO)o; //다운캐스팅
		JobDAO dao = new JobDAO();
		boolean result = dao.insertData(dto);
		if(result) {
			dao.commit();
			dao.close();
			return true;
		} else {
		dao.rollback();
		dao.close();
		return false;
		}
	}

	@Override
	public boolean modify(Object o) {
		JobDTO dto = (JobDTO)o; //다운캐스팅
		JobDAO dao = new JobDAO();
		boolean result = dao.updateData(dto);
		if(result) {
			dao.commit();
			dao.close();
			return true;
		} else {
		dao.rollback();
		dao.close();
		return false;
		}
	}

	@Override
	public boolean remove(Object o) {
		JobDTO dto = (JobDTO)o; //다운캐스팅
		JobDAO dao = new JobDAO();
		boolean result = dao.deleteData(dto);
		if(result) {
			dao.commit();
			dao.close();
			return true;
		} else {
		dao.rollback();
		dao.close();
		return false;
		}
	}
	
	@Override
	public boolean remove(int i) {
		JobDAO dao = new JobDAO();
		boolean result = dao.deleteData(i);
		if(result) {
			dao.commit();
			dao.close();
			return true;
		} else {
		dao.rollback();
		dao.close();
		return false;
		}
	}
 

}
