package io.github.himcs.model;

import com.google.gson.annotations.SerializedName;

public class TopicTagsItem{

	@SerializedName("__typename")
	private String typename;

	@SerializedName("name")
	private String name;

	@SerializedName("translatedName")
	private String translatedName;

	@SerializedName("slug")
	private String slug;

	public String getTypename(){
		return typename;
	}

	public String getName(){
		return name;
	}

	public String getTranslatedName(){
		return translatedName;
	}

	public String getSlug(){
		return slug;
	}

	@Override
 	public String toString(){
		return 
			"TopicTagsItem{" + 
			"__typename = '" + typename + '\'' + 
			",name = '" + name + '\'' + 
			",translatedName = '" + translatedName + '\'' + 
			",slug = '" + slug + '\'' + 
			"}";
		}
}