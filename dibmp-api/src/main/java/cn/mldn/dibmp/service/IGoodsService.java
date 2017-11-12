package cn.mldn.dibmp.service ;

import java.util.List;
import java.util.Map;

import cn.mldn.dibmp.vo.Goods;
import cn.mldn.dibmp.vo.Subtype;
import cn.mldn.dibmp.vo.Witem;


public interface IGoodsService  {
	/**
	 * 根据商品编号查询 商品信息数据
	 * 根据商品分类信息wiid查询出  仓库分类信息
	 * 根据商品分类信息stid查询出 仓库子分类数据信息
	 * @param gid 商品编号
	 * @return 返回所有商品分类信息和商品子分类信息
	 * key = allGoods     value = this.goodsDAO.findAllByGid(gid);
	 * key = allWitems     value = this.goodsDAO.findAllWitem();
	 * key = allSubtypes     value = this.findSubtypeByWiid(allGoods.getWiid());
	 */
	public Map<String,Object> edit_pre(long gid);
	/**
	 * 根据员工编号查询员工信息 
	 * @param mid 员工编号
	 * @return 返回所有员工信息
	 * key = allMember   value = goodsDAO.findMemberByMid
	 * key = allLevel    value = goodsDAO.findLevelByLid
	 * key =allDept      value = goodsDAO.findDepteByDid
	 */
	public Map<String,Object> getMemberByLevelAndDept(String mid);
	/**
	 * 根据商品对象vo中保存的数据,添加用户信息
	 * @param vo 用户要添加的商品数据信息
	 * @return 添加成功返回true
	 */
	public  boolean add(Goods vo);
	/**
	 * 根据传入的商品vo更改数据，以商品修改ID为条件
	 * @param vo  要进行修改的商品数据参数
	 * @return 修改成功返回true，修改失败返回false
	 */
	public boolean edit(Goods vo);
	/**
	 * 根据用户ID获得一个用户的完整对象信息，包含有密码和锁定状态
	 * @param mid 要查询的用户ID
	 * @return 用户对象，如果用户不存在返回null
	 */
	public Goods get(Long gid) ;
	
	/**
	 * 查询所有的商品分类
	 * @return 返回 所有商品数据的List集合
	 */
	public List<Witem> list();
	
	/**
	 * 根据商品分类id 查询商品子分类信息
	 * @return 返回商品子分类数据集合
	 */
	public	List<Subtype> getAllSubtype(Long wiid);

	/**
	 * 查询所有商品数据
	 * @return 返回获取商品数据信息
	 */
	public Map<String,Object> findSplitForGoods(String column,String keyWord,long currentPage, int lineSize);
	/**
	 * 根据商品编号查询商品信息
	 * @param gid 要查询的商品编号
	 * @return   返回当前的商品的数据信息
	 */
	public Map<String, Object> show(long gid);
	/**
	 * 根据商品所在的仓库分类编号，取得仓库数据信息
	 * @param wiid 商品分类编号（即仓库分类编号）；
	 * @return 返回仓库信息数据
	 */
	public Map<String,Object>  getWarehouse(long wiid);
	
//	/**
//	 * 根据用户ID获得一个用户的完整对象信息，包含有密码和锁定状态
//	 * @param mid 要查询的用户ID
//	 * @return 用户对象，如果用户不存在返回null
//	 */
  //	public Goods get(String mid) ;
//	/**
//	 * 根据指定的用户编号获得其对应的所有授权信息（角色、权限）
//	 * @param mid 用户ID
//	 * @return 返回的信息里面包含有两类数据：
//	 * 1、key = allRoles、value = 该用户具备的所有角色；
//	 * 2、key = allActions、value = 该用户具备的所有权限
//	 */
//  public Map<String,Set<String>> getRoleAndActionByMember(String mid) ;
 }
