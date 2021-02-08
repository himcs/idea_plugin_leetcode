package io.github.himcs.util;

import com.google.gson.Gson;
import io.github.himcs.model.CodeSnippetsItem;
import io.github.himcs.model.Data;
import io.github.himcs.model.Question;
import io.github.himcs.model.Response;
import io.github.himcs.model.TopicTagsItem;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;

/**
 * @author mcs [lik0x01@sp.noahgroup.com]
 */
public class LeetCodeUtil {

  private static void doWork(Response response) {
    System.out.println(response);
    Data data = response.getData();
    Question question = data.getQuestion();
    List<TopicTagsItem> topicTags = question.getTopicTags();
    TopicTagsItem topicTagsItem = topicTags.get(0);

    List<CodeSnippetsItem> codeSnippets = question.getCodeSnippets();
    Optional<CodeSnippetsItem> first = codeSnippets.stream()
        .filter(codeSnippetsItem -> "Java".equalsIgnoreCase(codeSnippetsItem.getLang()))
        .findFirst();
    CodeSnippetsItem codeSnippetsItem = first.get();
    String translatedTitle = question.getTranslatedTitle();
    String translatedContent = question.getTranslatedContent();
    String translatedName = topicTagsItem.getTranslatedName();
    String code = codeSnippetsItem.getCode();
    String questionId = question.getQuestionId();

//    System.out.println(translatedTitle);
//    System.out.println(translatedContent);
//    System.out.println(translatedName);
//    System.out.println(code);

    String packageName =
        "package " + translatedName + ".Q" + questionId + "_" + translatedTitle.trim();
    String stringBuilder = packageName + ";\n\n/**\n" + translatedContent + "\n**/\n"
        + code;
    String fileName = "Solution.java";

//    System.out.println(stringBuilder);
    try {
      Files.write(Paths.get(fileName), stringBuilder.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static String getVariables(String url) {
    String[] split = url.split("/");
    return split[split.length - 1];
  }

  public static Response getResponseSync(String URL) {
    String variables = getVariables(URL);
    String url = "https://leetcode-cn.com/graphql/";
    String json = "{\"operationName\":\"questionData\",\"variables\":{\"titleSlug\":\"" + variables
        + "\"},\"query\":\"query questionData($titleSlug: String!) {\\n  question(titleSlug: $titleSlug) {\\n    questionId\\n    questionFrontendId\\n    boundTopicId\\n    title\\n    titleSlug\\n    content\\n    translatedTitle\\n    translatedContent\\n    isPaidOnly\\n    difficulty\\n    likes\\n    dislikes\\n    isLiked\\n    similarQuestions\\n    contributors {\\n      username\\n      profileUrl\\n      avatarUrl\\n      __typename\\n    }\\n    langToValidPlayground\\n    topicTags {\\n      name\\n      slug\\n      translatedName\\n      __typename\\n    }\\n    companyTagStats\\n    codeSnippets {\\n      lang\\n      langSlug\\n      code\\n      __typename\\n    }\\n    stats\\n    hints\\n    solution {\\n      id\\n      canSeeDetail\\n      __typename\\n    }\\n    status\\n    sampleTestCase\\n    metaData\\n    judgerAvailable\\n    judgeType\\n    mysqlSchemas\\n    enableRunCode\\n    envInfo\\n    book {\\n      id\\n      bookName\\n      pressName\\n      source\\n      shortDescription\\n      fullDescription\\n      bookImgUrl\\n      pressImgUrl\\n      productUrl\\n      __typename\\n    }\\n    isSubscribed\\n    isDailyQuestion\\n    dailyRecordStatus\\n    editorType\\n    ugcQuestionId\\n    style\\n    exampleTestcases\\n    __typename\\n  }\\n}\\n\"}\n";
    okhttp3.MediaType JSON = okhttp3.MediaType.parse("application/json;charset=utf-8");
    OkHttpClient okHttpClient = new OkHttpClient();
    RequestBody requestBody = RequestBody.create(json, JSON);
    Request request = new Request.Builder()
        .post(requestBody)
        .url(url)
        .build();
    try {
      okhttp3.Response rep = okHttpClient.newCall(request).execute();
      String result = Objects.requireNonNull(rep.body()).string();
      Gson gson = new Gson();
      Response response = gson.fromJson(result, Response.class);
      return response;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void getResponse(String URL, Consumer<Response> consumer) {
    String variables = getVariables(URL);
    String url = "https://leetcode-cn.com/graphql/";
    String json = "{\"operationName\":\"questionData\",\"variables\":{\"titleSlug\":\"" + variables
        + "\"},\"query\":\"query questionData($titleSlug: String!) {\\n  question(titleSlug: $titleSlug) {\\n    questionId\\n    questionFrontendId\\n    boundTopicId\\n    title\\n    titleSlug\\n    content\\n    translatedTitle\\n    translatedContent\\n    isPaidOnly\\n    difficulty\\n    likes\\n    dislikes\\n    isLiked\\n    similarQuestions\\n    contributors {\\n      username\\n      profileUrl\\n      avatarUrl\\n      __typename\\n    }\\n    langToValidPlayground\\n    topicTags {\\n      name\\n      slug\\n      translatedName\\n      __typename\\n    }\\n    companyTagStats\\n    codeSnippets {\\n      lang\\n      langSlug\\n      code\\n      __typename\\n    }\\n    stats\\n    hints\\n    solution {\\n      id\\n      canSeeDetail\\n      __typename\\n    }\\n    status\\n    sampleTestCase\\n    metaData\\n    judgerAvailable\\n    judgeType\\n    mysqlSchemas\\n    enableRunCode\\n    envInfo\\n    book {\\n      id\\n      bookName\\n      pressName\\n      source\\n      shortDescription\\n      fullDescription\\n      bookImgUrl\\n      pressImgUrl\\n      productUrl\\n      __typename\\n    }\\n    isSubscribed\\n    isDailyQuestion\\n    dailyRecordStatus\\n    editorType\\n    ugcQuestionId\\n    style\\n    exampleTestcases\\n    __typename\\n  }\\n}\\n\"}\n";
    okhttp3.MediaType JSON = okhttp3.MediaType.parse("application/json;charset=utf-8");
    OkHttpClient okHttpClient = new OkHttpClient();
    RequestBody requestBody = RequestBody.create(json, JSON);
    Request request = new Request.Builder()
        .post(requestBody)
        .url(url)
        .build();
    okHttpClient.newCall(request).enqueue(new Callback() {
      @Override
      public void onFailure(@NotNull Call call, @NotNull IOException e) {

      }

      @Override
      public void onResponse(@NotNull Call call, @NotNull okhttp3.Response rep)
          throws IOException {

        String result = Objects.requireNonNull(rep.body()).string();
        Gson gson = new Gson();
        Response response = gson.fromJson(result, Response.class);
        consumer.accept(response);
      }
    });
  }

  public static void main(String[] args) throws Exception {
    getResponse("https://leetcode-cn.com/problems/sparse-array-search-lcci/", LeetCodeUtil::doWork);
  }
}
