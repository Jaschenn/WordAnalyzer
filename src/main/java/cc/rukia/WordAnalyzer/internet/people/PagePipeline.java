package cc.rukia.WordAnalyzer.internet.people;


import org.apache.http.util.TextUtils;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;


@SuppressWarnings("deprecation")
@PipelineName("peoplePagePipeline")
public class PagePipeline implements Pipeline<PeopleIndex>{

	public void process(PeopleIndex peopleIndex) {
		// TODO Auto-generated method stub
	
		//获取到网页的标题
		for(int i=0;i<peopleIndex.getIdList().size();i++) {
			System.out.println(peopleIndex.getNameList().size());
			if(!TextUtils.isEmpty(peopleIndex.getNameList().get(i))) {
				String url = peopleIndex.getIdList().get(i);
				
				HttpRequest currRequest = peopleIndex.getRequest();
				
				SchedulerContext.into(currRequest.subRequest(url));	
				
			}
		}
		System.out.println("-----------------------------------------------");
		for(int i=0;i<peopleIndex.getPageUrlList().size();i++) {
			String pageName = peopleIndex.getPageNameList().get(i);
			if(pageName!=null&&pageName.equals("下一页")) {
				String url = peopleIndex.getPageUrlList().get(i);
				
			   HttpRequest currRequest = peopleIndex.getRequest();
			
			  SchedulerContext.into(currRequest.subRequest(url));	
			}
		}
		
	}

}
