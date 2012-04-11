package uk.ac.aber.dcs.cs12420.aberpizza.data;

public abstract class AbstractDiscount implements Discount {
	private String description;

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String s) {
		description = s;
	}

}
