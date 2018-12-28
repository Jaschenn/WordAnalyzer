package cc.rukia.WordAnalyzer.internet.people;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;

@PipelineName(value="DetatilPipeline")
public class DetatilPipeline implements Pipeline<DetailPage>{

	public void process(DetailPage bean) {
		System.out.println("得到的标题是"+bean.getTitle());
		System.out.println("正文"+bean.getContent().toString());
		System.out.println();
	}

}
