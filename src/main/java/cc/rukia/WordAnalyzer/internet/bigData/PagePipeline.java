package cc.rukia.WordAnalyzer.internet.bigData;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;

@PipelineName(value="PagePipeline")
public class PagePipeline implements Pipeline<BigDataIndex>{

	//添加每个详细信息
	public void process(BigDataIndex bean) {
		for(int i=0;i<bean.getContentUrl().size();i++) {
			if(bean.getContentName().get(i)!=null) {
                HttpRequest currRequest = bean.getRequest();
				//System.out.println(bean.getContentUrl().get(i));
				SchedulerContext.into(currRequest.subRequest(bean.getContentUrl().get(i)));	
			}
		}
		//添加页数
		int totalnumber = Integer.parseInt(bean.getNumber());
		//System.out.println("总页数是"+totalnumber);
		for(int j=2;j<=totalnumber;j++) {
			HttpRequest currRequest = bean.getRequest();
			String url = "http://www.cbdio.com/index_"+j+".html";
			SchedulerContext.into(currRequest.subRequest(url));		
		}
	}
	
	

}
