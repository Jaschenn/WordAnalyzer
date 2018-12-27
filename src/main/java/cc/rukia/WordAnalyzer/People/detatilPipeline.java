package cc.rukia.WordAnalyzer.People;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;

@PipelineName(value="pagePipeline2")
public class detatilPipeline implements Pipeline<detailPage>{

	public void process(detailPage bean) {
		System.out.println("得到的标题是"+bean.getTitle());
		System.out.println("正文"+bean.getContent().toString());
		System.out.println();
	}

}
