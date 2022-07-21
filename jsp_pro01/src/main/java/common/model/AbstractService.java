package common.model;

import java.util.List;

public abstract class AbstractService {

		//뭐가 들어가야할지 모르겠으면 그냥 Object로 명시해라 모든클래스는 Object를 상속하기 때문
		public abstract Object getAll();
		public abstract Object getId(Object o);
		public abstract Object getId(int i);
		public abstract boolean add(Object o);
		public abstract boolean modify(Object o);
		public abstract boolean remove(Object o);
		public abstract boolean remove(int i);
}
