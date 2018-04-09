package cn.sxt.vo;

/**
 * 商品
 * 
 * @author Mypc
 *
 */
public class T_commodity {
	private int commodityId;
	private String commodityName;
	private float commodityPrice;
	private String commodityURL;
	private String commodityIsMan;
	private String commodityIsShelves;
	// 多对一
	private T_gategories t_gategories;

	public int getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public float getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(float commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public String getCommodityURL() {
		return commodityURL;
	}

	public void setCommodityURL(String commodityURL) {
		this.commodityURL = commodityURL;
	}

	public String getCommodityIsMan() {
		return commodityIsMan;
	}

	public void setCommodityIsMan(String commodityIsMan) {
		this.commodityIsMan = commodityIsMan;
	}

	public String getCommodityIsShelves() {
		return commodityIsShelves;
	}

	public void setCommodityIsShelves(String commodityIsShelves) {
		this.commodityIsShelves = commodityIsShelves;
	}

	public T_gategories getT_gategories() {
		return t_gategories;
	}

	public void setT_gategories(T_gategories t_gategories) {
		this.t_gategories = t_gategories;
	}

}
