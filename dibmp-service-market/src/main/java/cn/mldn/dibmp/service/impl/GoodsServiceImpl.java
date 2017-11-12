package cn.mldn.dibmp.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IGoodsDAO;
import cn.mldn.dibmp.service.IGoodsService;
import cn.mldn.dibmp.vo.Goods;
import cn.mldn.dibmp.vo.Subtype;
import cn.mldn.dibmp.vo.Witem;
import cn.mldn.util.service.abs.AbstractService;
@Service
public class GoodsServiceImpl  extends AbstractService  implements IGoodsService {
	@Resource
	private IGoodsDAO goodsDAO;


	@Override
	public boolean add(Goods vo) {
		if(goodsDAO.findByName(vo.getName())==null){
			return this.goodsDAO.doCreate(vo);	
		}
		return false;
	}

	@Override
	public Goods get(Long gid) {
		return null;
	}

	@Override
	public List<Witem> list() {
		return goodsDAO.findAllWitem();
	}

	@Override
	public List<Subtype> getAllSubtype(Long wiid) {
		return goodsDAO.findSubtypeByWiid(wiid);
	}

   @Override
	public Map<String, Object> findSplitForGoods(String column, String keyWord, long currentPage, int lineSize) {
	Map<String,Object> map=new HashMap<String,Object> ();
	Map<String,Object> mapdao= super.paramToMap(currentPage, lineSize, column, keyWord);
	List<Goods>  allGoods= this.goodsDAO.findSplitOrderByGid(mapdao);
	Map<String,String> memberName= new HashMap<String,String>();
	Iterator<Goods> iter = allGoods.iterator();
	while(iter.hasNext()) {
		Goods vo = iter.next();
		memberName.put(vo.getRecorder(), this.goodsDAO.findNameByMid(vo.getRecorder()));
}
	map.put("memberName", memberName);
	map.put("allGoods", allGoods);
	map.put("allRecorders", this.goodsDAO.getSplitCount(mapdao));
	
			
		return map;
	}

@Override
public Map<String, Object> show(long gid) {
	Map<String,Object>  map =new HashMap<String,Object>();
	map.put("allGoods", this.goodsDAO.findAllByGid(gid));
	return map;
}

@Override
public Map<String, Object> getWarehouse(long wiid) {
	Map<String,Object> map =new HashMap<String,Object>();
	map.put("allWareHourse", this.goodsDAO.findAllByWiid(wiid))	;
	map.put("allCity", this.goodsDAO.findCityByCid(this.goodsDAO.findAllByWiid(wiid).getCid()))	;
	map.put("allProvince", this.goodsDAO.findProvinceBypid(this.goodsDAO.findAllByWiid(wiid).getPid()))	;
	System.out.println(map.get("allWareHourse"));
	System.out.println(map.get("allCity"));
	System.out.println(map.get("allProvince"));
	return map;
	
}

@Override
public Map<String, Object> getMemberByLevelAndDept(String mid) {
	Map<String,Object> map = new HashMap<String,Object> ();
		System.err.println("GoodsService"+ mid);
		System.err.println("11111111"+ this.goodsDAO.findMemberByMid(mid));
		System.err.println("122222222"+this.goodsDAO.findLevelByLid(this.goodsDAO.findMemberByMid(mid).getLid()));
		System.err.println("133333333"+this.goodsDAO.findDepteByDid(this.goodsDAO.findMemberByMid(mid).getDid()));
		map.put("allMember", this.goodsDAO.findMemberByMid(mid));
		map.put("allLevel", this.goodsDAO.findLevelByLid(this.goodsDAO.findMemberByMid(mid).getLid()));
		map.put("allDept", this.goodsDAO.findDepteByDid(this.goodsDAO.findMemberByMid(mid).getDid()));
	
	return map;
}

@Override
public boolean edit(Goods vo) {
	
	return this.goodsDAO.doEdit(vo);
}

@Override
public Map<String, Object> edit_pre(long gid) {
	Map<String,Object> map =new HashMap<String,Object>()	;
	Goods goods = this.goodsDAO.findAllByGid(gid);
	map.put("allGoods", this.goodsDAO.findAllByGid(gid));
	map.put("allWitems",  this.goodsDAO.findAllWitem());
	map.put("allSubtypes", this.goodsDAO.findSubtypeByWiid(goods.getWiid()));
	return map;
}

   


	}





	



//	@Resource
//	private IMemberDAO memberDAO ;
//	@Resource
//	private IRoleDAO roleDAO ;
//	@Resource
//	private IActionDAO actionDAO ;
//	@Override
//	public Member get(String mid) {
//		return this.memberDAO.findById(mid);
//	}
//
//	@Override
//	public Map<String, Set<String>> getRoleAndActionByMember(String mid) {
//		Map<String, Set<String>> map = new HashMap<>() ;
//		map.put("allRoles", this.roleDAO.findAllByMember(mid)) ;
//		map.put("allActions", this.actionDAO.findAllByMember(mid)) ;
//		return map;
//	}


