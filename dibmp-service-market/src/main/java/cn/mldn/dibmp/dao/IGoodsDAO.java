package cn.mldn.dibmp.dao;

import java.util.List;
import java.util.Map;


import cn.mldn.dibmp.vo.City;
import cn.mldn.dibmp.vo.Dept;
import cn.mldn.dibmp.vo.Goods;
import cn.mldn.dibmp.vo.Level;
import cn.mldn.dibmp.vo.Member;
import cn.mldn.dibmp.vo.Province;
import cn.mldn.dibmp.vo.Subtype;
import cn.mldn.dibmp.vo.Warehouse;
import cn.mldn.dibmp.vo.Witem;


public interface IGoodsDAO {
	
	/**
	 *进行数据的修改处理操作，调用UPDATE语法执行，是以ID为修改条件
	 * @param vo 要修改的新数据
	 * @return 如果修改的数据成功返回true，如果修改数据不存在则返回false
	 */
	public boolean doEdit(Goods vo) ;
	
	public boolean doCreate(Goods vo);

	public Goods findByName(String name);
	/**
	 * 查询商品分类的编号和标题
	 * @return 返回商品分类数据
	 */
	public List<Witem> findAllWitem();
	
	public List<Subtype> findSubtypeByWiid(Long wiid);
	/**
	 * 根据gid进行关键字的分组模糊查询
	 * @return 返回商品信息数据的List集合
	 */
    public List<Goods>  findSplitOrderByGid(Map<String,Object> map);
    
    /**
     * 根据关键字模糊查询所标记为0的商品，
     * @param map
     * @return	返回满足关键字查询的条件的商品个数
     */
    public long getSplitCount(Map<String,Object> map);
    /**
     * 根据商品编号查询商品名称
     * @param mid 商品编号
     * @return  返回查询的商品名称
     */
    public String  findNameByMid(String mid);
    /**
     * 根据商品编号查询商品数据信息
     * @param gid  商品编号
     * @return  返回当前商品数据信息
     */
    public  Goods  findAllByGid(Long gid);
    /**
     * 根据商品分类编号查询商品仓库信息数据
     * @param wiid   商品分类信息
     * @return 返回   仓库信息数据信息
     */
    public  Warehouse findAllByWiid(Long wiid);
    /**
     * 根据用户编号查询用户信息
     * @param mid 用户编号
     * @return 返回用户信息数据
     */
    public Member findMemberByMid(String mid);
    /**
     * 根据用户等级编号查询 用户等级
     * @param lid 用户等级编号
     * @return 返回用户等级信息数据
     */
    public Level findLevelByLid(Long lid);
    /**
     * 根据用户所在部门编号查询用户部门信息数据
     * @param did 用户部门信息
     * @return 返回部门信息数据
     */
    public Dept findDepteByDid(Long did);
    /**
     * 根据仓库所在省份id 查询仓库所在省份名称
     * @param pic 省份id
     * @return 返回仓库所在省份名称
     */
    public Province findProvinceBypid(Long pid);
    /**
     * 根据仓库所在的城市id 查询仓库所在的城市名称
     * @param cid 仓库所在的城市id
     * @return 返回仓库所在的城市名称
     */
    public City findCityByCid(Long cid);
    
}
