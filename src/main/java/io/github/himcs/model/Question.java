package io.github.himcs.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Question{

	@SerializedName("sampleTestCase")
	private String sampleTestCase;

	@SerializedName("enableRunCode")
	private boolean enableRunCode;

	@SerializedName("questionId")
	private String questionId;

	@SerializedName("codeSnippets")
	private List<CodeSnippetsItem> codeSnippets;

	@SerializedName("translatedTitle")
	private String translatedTitle;

	@SerializedName("book")
	private Object book;

	@SerializedName("__typename")
	private String typename;

	@SerializedName("title")
	private String title;

	@SerializedName("content")
	private String content;

	@SerializedName("topicTags")
	private List<TopicTagsItem> topicTags;

	@SerializedName("judgerAvailable")
	private boolean judgerAvailable;

	@SerializedName("titleSlug")
	private String titleSlug;

	@SerializedName("metaData")
	private String metaData;

	@SerializedName("isSubscribed")
	private boolean isSubscribed;

	@SerializedName("questionFrontendId")
	private String questionFrontendId;

	@SerializedName("ugcQuestionId")
	private Object ugcQuestionId;

	@SerializedName("solution")
	private Object solution;

	@SerializedName("similarQuestions")
	private String similarQuestions;

	@SerializedName("stats")
	private String stats;

	@SerializedName("exampleTestcases")
	private String exampleTestcases;

	@SerializedName("envInfo")
	private String envInfo;

	@SerializedName("judgeType")
	private String judgeType;

	@SerializedName("mysqlSchemas")
	private List<Object> mysqlSchemas;

	@SerializedName("likes")
	private int likes;

	@SerializedName("langToValidPlayground")
	private String langToValidPlayground;

	@SerializedName("boundTopicId")
	private int boundTopicId;

	@SerializedName("dailyRecordStatus")
	private Object dailyRecordStatus;

	@SerializedName("hints")
	private List<String> hints;

	@SerializedName("isLiked")
	private Object isLiked;

	@SerializedName("isPaidOnly")
	private boolean isPaidOnly;

	@SerializedName("dislikes")
	private int dislikes;

	@SerializedName("isDailyQuestion")
	private boolean isDailyQuestion;

	@SerializedName("difficulty")
	private String difficulty;

	@SerializedName("style")
	private String style;

	@SerializedName("contributors")
	private List<Object> contributors;

	@SerializedName("translatedContent")
	private String translatedContent;

	@SerializedName("editorType")
	private String editorType;

	@SerializedName("companyTagStats")
	private Object companyTagStats;

	@SerializedName("status")
	private Object status;

	public String getSampleTestCase(){
		return sampleTestCase;
	}

	public boolean isEnableRunCode(){
		return enableRunCode;
	}

	public String getQuestionId(){
		return questionId;
	}

	public List<CodeSnippetsItem> getCodeSnippets(){
		return codeSnippets;
	}

	public String getTranslatedTitle(){
		return translatedTitle;
	}

	public Object getBook(){
		return book;
	}

	public String getTypename(){
		return typename;
	}

	public String getTitle(){
		return title;
	}

	public String getContent(){
		return content;
	}

	public List<TopicTagsItem> getTopicTags(){
		return topicTags;
	}

	public boolean isJudgerAvailable(){
		return judgerAvailable;
	}

	public String getTitleSlug(){
		return titleSlug;
	}

	public String getMetaData(){
		return metaData;
	}

	public boolean isIsSubscribed(){
		return isSubscribed;
	}

	public String getQuestionFrontendId(){
		return questionFrontendId;
	}

	public Object getUgcQuestionId(){
		return ugcQuestionId;
	}

	public Object getSolution(){
		return solution;
	}

	public String getSimilarQuestions(){
		return similarQuestions;
	}

	public String getStats(){
		return stats;
	}

	public String getExampleTestcases(){
		return exampleTestcases;
	}

	public String getEnvInfo(){
		return envInfo;
	}

	public String getJudgeType(){
		return judgeType;
	}

	public List<Object> getMysqlSchemas(){
		return mysqlSchemas;
	}

	public int getLikes(){
		return likes;
	}

	public String getLangToValidPlayground(){
		return langToValidPlayground;
	}

	public int getBoundTopicId(){
		return boundTopicId;
	}

	public Object getDailyRecordStatus(){
		return dailyRecordStatus;
	}

	public List<String> getHints(){
		return hints;
	}

	public Object getIsLiked(){
		return isLiked;
	}

	public boolean isIsPaidOnly(){
		return isPaidOnly;
	}

	public int getDislikes(){
		return dislikes;
	}

	public boolean isIsDailyQuestion(){
		return isDailyQuestion;
	}

	public String getDifficulty(){
		return difficulty;
	}

	public String getStyle(){
		return style;
	}

	public List<Object> getContributors(){
		return contributors;
	}

	public String getTranslatedContent(){
		return translatedContent;
	}

	public String getEditorType(){
		return editorType;
	}

	public Object getCompanyTagStats(){
		return companyTagStats;
	}

	public Object getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Question{" + 
			"sampleTestCase = '" + sampleTestCase + '\'' + 
			",enableRunCode = '" + enableRunCode + '\'' + 
			",questionId = '" + questionId + '\'' + 
			",codeSnippets = '" + codeSnippets + '\'' + 
			",translatedTitle = '" + translatedTitle + '\'' + 
			",book = '" + book + '\'' + 
			",__typename = '" + typename + '\'' + 
			",title = '" + title + '\'' + 
			",content = '" + content + '\'' + 
			",topicTags = '" + topicTags + '\'' + 
			",judgerAvailable = '" + judgerAvailable + '\'' + 
			",titleSlug = '" + titleSlug + '\'' + 
			",metaData = '" + metaData + '\'' + 
			",isSubscribed = '" + isSubscribed + '\'' + 
			",questionFrontendId = '" + questionFrontendId + '\'' + 
			",ugcQuestionId = '" + ugcQuestionId + '\'' + 
			",solution = '" + solution + '\'' + 
			",similarQuestions = '" + similarQuestions + '\'' + 
			",stats = '" + stats + '\'' + 
			",exampleTestcases = '" + exampleTestcases + '\'' + 
			",envInfo = '" + envInfo + '\'' + 
			",judgeType = '" + judgeType + '\'' + 
			",mysqlSchemas = '" + mysqlSchemas + '\'' + 
			",likes = '" + likes + '\'' + 
			",langToValidPlayground = '" + langToValidPlayground + '\'' + 
			",boundTopicId = '" + boundTopicId + '\'' + 
			",dailyRecordStatus = '" + dailyRecordStatus + '\'' + 
			",hints = '" + hints + '\'' + 
			",isLiked = '" + isLiked + '\'' + 
			",isPaidOnly = '" + isPaidOnly + '\'' + 
			",dislikes = '" + dislikes + '\'' + 
			",isDailyQuestion = '" + isDailyQuestion + '\'' + 
			",difficulty = '" + difficulty + '\'' + 
			",style = '" + style + '\'' + 
			",contributors = '" + contributors + '\'' + 
			",translatedContent = '" + translatedContent + '\'' + 
			",editorType = '" + editorType + '\'' + 
			",companyTagStats = '" + companyTagStats + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}