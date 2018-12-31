package cc.rukia.WordAnalyzer.internet.AI;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;

@PipelineName(value="AIPagePipeline")
public class PagePipeline implements Pipeline<AIIndex>{

	//添加每个详细信息
	public void process(AIIndex bean) {
		HttpRequest currRequest = bean.getRequest();
		for(int i=0;i<bean.getContentUrl().size();i++) {
			if(bean.getContentName().get(i)!=null) {
                
				//System.out.println(bean.getContentUrl().get(i));
				SchedulerContext.into(currRequest.subRequest(bean.getContentUrl().get(i)));	
			}
		}
		SchedulerContext.into(currRequest.subRequest(bean.getNextUrl()));			
		}
	}
	
	


