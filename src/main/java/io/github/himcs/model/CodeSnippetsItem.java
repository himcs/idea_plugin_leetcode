package io.github.himcs.model;

import com.google.gson.annotations.SerializedName;

public class CodeSnippetsItem{

	@SerializedName("code")
	private String code;

	@SerializedName("__typename")
	private String typename;

	@SerializedName("langSlug")
	private String langSlug;

	@SerializedName("lang")
	private String lang;

	public String getCode(){
		return code;
	}

	public String getTypename(){
		return typename;
	}

	public String getLangSlug(){
		return langSlug;
	}

	public String getLang(){
		return lang;
	}

	@Override
 	public String toString(){
		return 
			"CodeSnippetsItem{" + 
			"code = '" + code + '\'' + 
			",__typename = '" + typename + '\'' + 
			",langSlug = '" + langSlug + '\'' + 
			",lang = '" + lang + '\'' + 
			"}";
		}
}