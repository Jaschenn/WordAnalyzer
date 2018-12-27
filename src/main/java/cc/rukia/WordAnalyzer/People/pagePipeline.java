package cc.rukia.WordAnalyzer.People;


import org.apache.http.util.TextUtils;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;


@SuppressWarnings("deprecation")
@PipelineName(value="pagePipeline1")
public class pagePipeline implements Pipeline<peopleIndex>{

	public void process(peopleIndex peopleIndex) {
		// TODO Auto-generated method stub
	
		//获取到网页的标题
		for(int i=0;i<peopleIndex.getIdList().size();i++) {
			//System.out.println(peopleIndex.getNameList().get(i));
			if(!TextUtils.isEmpty(peopleIndex.getNameList().get(i))) {
				String url = peopleIndex.getNameList().get(i);
				//System.out.println("得到的地址是"+url);
				HttpRequest currRequest = peopleIndex.getRequest();
				SchedulerContext.into(currRequest.subRequest(url));	
			}
		}
		
		for(int i=0;i<peopleIndex.getPageUrlList().size();i++) {
			String pageName = peopleIndex.getPageNameList().get(i);
			//System.out.println("pageName"+pageName);
			if(pageName!=null&&pageName.equals("下一页")) {
				String url = peopleIndex.getPageUrlList().get(i);
				
			   HttpRequest currRequest = peopleIndex.getRequest();
			  //System.out.println("url"+url);
			  SchedulerContext.into(currRequest.subRequest(url));	
			}
		}
		//System.out.println("抓取到的网址是"+pageIndex.getNameList().toString());
		//System.out.println("页数的超链接"+pageIndex.getPageNameList().toString());
	}

}
