package cn.mldn.dibmp.service.test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.service.IGoodsService;
import cn.mldn.dibmp.vo.Goods;
import cn.mldn.dibmp.vo.Member;
import cn.mldn.dibmp.vo.Subtype;
import cn.mldn.dibmp.vo.Witem;
import junit.framework.TestCase;
@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestGoodsService extends TestCase {
	@Resource
	private IGoodsService goodsService;
	@Test
	public void editTest() {
		Goods vo =new Goods();
		
		vo.setName("上衣");
		vo.setWeight(1.5);
		vo.setWiid(1l);
		vo.setPrice(110.0);
		vo.setPhoto("jsp");
		vo.setNote("henhao");
		vo.setStid(1l);
		this.goodsService.edit(vo);
		System.out.println(this.goodsService.edit(vo));
	}
	@Test
	public void testAdd() {
		Goods vo = new Goods();
		vo.setName("上衣");
		vo.setWeight(1.5);
		vo.setWiid(1l);
		vo.setPrice(110.0);
		vo.setPhoto("jsp");
		vo.setNote("henhao");
		vo.setStid(1l);
		vo.setLastin(new Date());
		vo.setStornum(55);
		vo.setRecorder("zhnagsan");
		vo.setDelflag(0);
		System.err.println(vo.toString());
		 try {
        	 TestCase.assertTrue(goodsService.add(vo));
         }catch(Exception e) {
        	 e.printStackTrace();
         }
	}
	@Test
	public void getTest() {
		  Goods goods = goodsService.get(1L);
		  System.err.println("对象数据" + goods);
	}
	@Test
	public void getWitemTest() {
		
	        List<Witem> allWitems  = goodsService.list();
	    System.out.println(allWitems.get(1));    
		
	}
	@Test
	public void getSubtypeTest() {
	  List<Subtype> allSubtype =goodsService.getAllSubtype(1l);
	  System.out.println(allSubtype);
	}
	@Test
	public void findSplitTest() {
		Map<String,Object> map =goodsService.findSplitForGoods(getName(), getName(), 1l, 1);
		System.out.println(map);
	}
	@Test
	public void getMemberByLevelAndDeptTest() {
		Member mem =new Member();
		mem.setMid("mldn-market");
		Map<String,Object> map =goodsService.getMemberByLevelAndDept(mem.getMid());
//		System.out.println(map.get("allMember"));;
		System.out.println(map.get("allLevel"));;
//		System.out.println(map.get("allDept"));;
		
	}
	@Test
	public void getWarehourse()	{
		Map<String,Object>map = goodsService.getWarehouse(1l);
		System.out.println(map.get("allGoods" ).toString()+ "aaaaaaaaaaaaaaaaaaaa");
	}
	
}
