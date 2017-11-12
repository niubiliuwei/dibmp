package cn.mldn.dibmp.web.action.back;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.dibmp.service.IGoodsService;
import cn.mldn.dibmp.vo.Goods;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.web.SplitPageUtil;

@Controller
@RequestMapping("pages/back/admin/goods/*")
public class GoodsActionBack extends AbstractAction {
	private static final String TITLE = "商品" ;
	@Resource
	private IGoodsService goodsService;
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("goods.add.page"));
		mav.addObject("allWitems",goodsService.list());
		return mav;
	}
	@RequestMapping("add")
	public ModelAndView add(Goods goods) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		if(goodsService.add(goods)) {
		super.setMsgAndUrl(mav, "goods.add.action", "vo.add.success", TITLE);
		}else {
			super.setMsgAndUrl(mav, "goods.add.action", "vo.add.failure", TITLE);
		}
		return mav;
	} 
	@RequestMapping("show")
	public ModelAndView show(Long gid) { 
		System.out.println("=============" +  gid);
		ModelAndView mav = new ModelAndView(super.getPage("goods.show.page"));
		mav.addAllObjects(this.goodsService.show(gid));
		return mav;
	}
	@RequestMapping("getSubtypeByWiid")
	@ResponseBody
	public Object getSubtypeByWiid(Long wiid){ 
		return this.goodsService.getAllSubtype(wiid);
	}
	@RequestMapping("edit_pre")
	public ModelAndView edit_pre(long gid) { 
		System.out.println("edit_pre" + gid );
		ModelAndView mav = new ModelAndView(super.getPage("goods.edit.page"));
		mav.addAllObjects(this.goodsService.edit_pre(gid));
		return mav;
	} 
	@RequestMapping("edit")
	public ModelAndView edit(Goods goods) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		if(goodsService.edit(goods)) {
		super.setMsgAndUrl(mav, "goods.list.action", "vo.edit.success", TITLE);
		}else {
			super.setMsgAndUrl(mav, "goods.list.action", "vo.edit.failure", TITLE);	
		}
		return mav;
	}
	@RequestMapping("list") 
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("商品编号:gid|商品名称:name", super.getPage("goods.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("goods.list.page"));
		Map<String,Object> map = this.goodsService.findSplitForGoods(spu.getColumn(), spu.getKeyWord(), spu.getCurrentPage(), spu.getLineSize());
		mav.addAllObjects(map);
		return mav;
	}
	@RequestMapping("getWarehouse")
	@ResponseBody
	public Object getWarehouse(Long wiid) {
		System.out.println("action.wiid" + this.goodsService.getWarehouse(wiid));
		
		return this.goodsService.getWarehouse(wiid);
	}
	@RequestMapping("getMemberByLevelAndDept")
	@ResponseBody
	public Object getMemberByLevelAndDept(String mid) {
		return this.goodsService.getMemberByLevelAndDept(mid);
		
	}
	
	
	
}
