import cc.rukia.WordAnalyzer.ansj.Word;
import cc.rukia.WordAnalyzer.util.SortUtil;
import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.ansj.dic.LearnTool;
import org.ansj.domain.Nature;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.library.DicLibrary;
import org.ansj.recognition.Recognition;
import org.ansj.recognition.impl.StopRecognition;
import org.ansj.splitWord.analysis.*;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.nlpcn.commons.lang.tire.domain.Forest;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class AnsjTest {
    @Test
    public void WordTest() {
        File file = new File("result.txt");
        List<String> lines = new ArrayList<String>();
        try {
            lines = FileUtils.readLines(file, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        if (lines.size() != 0) {
            Iterator iterator = lines.iterator();
            while (iterator.hasNext()) {
                String title = (String) iterator.next();
                String content = (String) iterator.next();
                KeyWordComputer keyWordComputer = new KeyWordComputer(content.length() / 100);
                Collection<Keyword> keywords = keyWordComputer.computeArticleTfidf(title, content);
                for (Keyword k : keywords
                ) {
                    System.out.println(k);
                    Word word = new Word(k.getName());
                    if(hashMap.containsKey(word.getName())){
                        int fre = (Integer) (hashMap.get(word.getName()));
                        hashMap.put(word.getName(),fre+1);
                    }else {
                        hashMap.put(word.getName(),1);
                    }

                }

            }
            StopRecognition filter = new StopRecognition();

        HashMap hashMap1 = (HashMap) SortUtil.sortByValue(hashMap);
        System.out.println(hashMap1);
        }
    }//测试添加了dic没有stopLibrary时候的准确度
    @Test
    public void LearnToolTest() throws IOException {
        // 构建一个新词学习的工具类。这个对象。保存了所有分词中出现的新词。出现次数越多。相对权重越大。
        LearnTool learnTool = new LearnTool();

        NlpAnalysis nlpAnalysis = new NlpAnalysis().setLearnTool(learnTool) ;

        // 进行词语分词。也就是nlp方式分词，这里可以分多篇文章
        StopRecognition stopRecognition = new StopRecognition();
        stopRecognition.insertStopNatures("nr");
        stopRecognition.insertStopNatures("nt");
        List<String> lines = FileUtils.readLines(new File("result.txt"),"utf-8");

        nlpAnalysis.parseStr("数字经济的下半场：跨越信息的鸿沟\n" +
                "刘志毅\n" +
                "刘志毅\n" +
                "数字经济学家，同济大学人工智能与区块链智能实验室（AIBI）研究员\n" +
                "5 人赞了该文章\n" +
                "2018年1月16日，在阿里研究院主办的新经济智库大会的“研究者之夜”上，通过前期公开征集和现场200位专家的投票，阿里研究院得到了2018年前十大关键词：区块链，人工智能，新零售，物联网，共享经济，普惠，大数据，无人驾驶，5G和生态。对比2017年的十大热词以后，共同的关键词是：人工智能，共享经济，新零售，大数据和区块链。新技术的崛起导致的数字经济变革势不可挡，而数字经济生态的变化则引发了整个社会发展内在动力的变化。从1969年互联网发明半个世纪以来，全球接近一半的人口已经实现了向数字大陆的迁徙，而随着互联网的发展，信息技术已经成为所有技术的核心，本文主要讨论的就是在互联网发展了接近半个世纪以后，数字经济发展到现在，其概念内涵发生了什么变化，以及未来数字经济的发展趋势如何。\n" +
                "\n" +
                "首先从数字经济的内涵讨论，即如何理解数字经济。“数字经济”一词最早来自于加拿大Tapscott首席执行官Don Tapscott1995年出版的畅销书《数字经济：网络智能时代的承诺与风险》中创造出来的，主要用来描述的就是互联网如何改变商业的范畴，而麻省理工媒体实验室的创始人尼葛洛庞帝则把数字经济描述为“用比特而不是原子”的隐喻来描述数字经济，在他那本众所周知的著作《数字化生存》中预言到，“比特代替原子；个人化双向沟通替代由上而下的大众传播，接收者主动地拽取信息替代传播者将信息”推排“给我们”。而如今，他关于数字化生存的预言大部分都成为了现实，数字经济也成为了不可忽视的经济现象之一，因而关于数字经济的概念，也就出现了新的共识，如果说以往的数字经济的概念主要是与计算机和互联网相关，那么随着大数据的技术的应用，尤其是在大数据发展基础上人工智能技术的应用，物联网技术的发展，数字经济的内涵就编程了以数据驱动的经济学概念，这也是我们现在理解数字经济概念的关键，也就是从广义上来说，数字经济是基于计算机技术和互联网的经济形态，而从技术角度定义，则是以大数据，人工智能和物联网等技术为基础的数据驱动的经济形态。这里我们就把数字经济跟以往的信息经济，网络经济或者互联网经济区分开来了，因为这些概念都是基于互联网或者计算机技术为主的经济形式，而事实上新的技术不断的被发现，而网络对经济形态的改变也不仅仅限于互联网端，我们需要从这个更深刻的层面理解互联网。\n" +
                "\n" +
                "然后我们来看看数字经济的现状如何，麦肯锡全球研究院（MGI）在2017年发布了一个报告《中国的数字经济：全球领先力量》中提到，中国是全球最活跃的数字经济生态系统之一，其过去几十年的发展超越了很多观察者预期，站到了世界的最前沿。具体说来，中国在虚拟现实、自动驾驶车辆、3D打印、机器人、无人机和人工智能(AI)等主要数字技术领域的风险投资额位居世界前三。它同时拥有着世界上最大的电子商务市场，占全球电子商务交易市场总额的40%以上，而在大约十年前，这一比例还不到1%。中国也成为了全球移动支付领域的主要力量，交易总额是美国的11倍。全球262家独角兽企业(估值超过10亿美元的初创企业)中，有三分之一是中国企业，且这些中国企业的价值占据全球独角兽企业总价值的43%。\n" +
                "\n" +
                "在中国数字经济发展中，最主要的发展关键因素是什么呢？第一，中国互联网用户群的庞大规模鼓励了企业持续进行实验创新，使数字经济的参与者能够迅速实现规模经济，我们可以看到互联网领域的商业模式创新大多数都基于庞大的用户基数为基础，如果没有这样的用户规模，所有的数字经济发展无从谈起，尤其是中国拥有世界上最好的移动互联网生态，在中国，近五分之一的互联网用户只依靠手机，而美国只有5%。中国互联网用户在移动数字支付方面所占的份额约为68%，而美国用户只占约15%。第二，中国过去数十年的互联网发展，产生了以BAT，小米，京东等为代表的互联网生态基础产业，它们不仅为整个数字经济的发展树立了标杆和旗帜，而且也创造了基本的互联网生态，以相对开放的方式促进了数字经济的发展；第三，政府实际上成为了数字经济发展过程中最容易被忽视的力量，事实上，虽然中国政府刚开始对互联网的态度给了创新者大量的实验空间，而随着市场的成熟，政府则主动通过监管和执法来促进更加健康的数字发展，并在过程中积极建设世界顶尖水平的基础设施，作为投资者、开发者和消费者支持着经济数字化。\n" +
                "\n" +
                "最后我们来讨论数字经济的未来趋势和热点如何，BCG在2017年的报告《迈向2035：4亿数字经济就业的未来报告》中的一些预测和数据值得我们关注，报告预测中预测到2035年中国整体数字经济规模接近16万亿美元，数字经济渗透率48%，总就业容量达4.15亿，而以互联网、云计算、大数据、物联网、人工智能等为代表的数字技术，将对就业生态带来革命性改变，具体说来可以从三个方面理解这些技术对未来数字经济的影响：\n" +
                "\n" +
                "第一， 数字技术广泛融入各行各业,深入改变传统行业的商业逻辑和运行方式。在这里，我们可以理解为革命性的技术会改变数字经济的发展，当前的新兴技术如人工智能等，很有可能像曾经的电力技术，蒸汽机和互联网一样，对整个经济的发展起到变革性的作用，而中国则在人工智能领域中目前处于第一梯队中，不仅从自主创新能力和人才积累上正在追赶美国，而且在商业应用和投资趋势上，也稳居世界第二的水平，这保证了中国在新一轮的技术浪潮中不会轻易落后，能够通过自主创新创造新的经济革命。\n" +
                "\n" +
                "第二，数字技术使新的组织内外协作模式顺畅运行,并更契合业务诉求。具体说来，在中国出现了很多产业融合的趋势，无论是“互联网+”的中国信息化方案的提出，还是“人工智能+“的新的趋势的出现，很多融合性的产业生态正在出现，过去十年间，移动互联网推动了中国互联网发展出以平台为载体，以数据为驱动，与传统产业广泛融合的”互联网+“的产业生态，而未来几十年间，我们可以预测到智能时代将来临，由于在云管端等多个方面的基础设施的发展，大部分企业拥有全面数字化转型的技术基础，尤其是随着国家对供给侧改革的重视，人工智能技术将对制造业带来完全不同于以往的互联网技术所带来的技术变革。\n" +
                "\n" +
                "第三，数字技术对人类劳动的可替代力越来越强,“数字原住民”将拥有新的数字时代工作价值观。也就是随着生长在互联网技术的发展，深入改变了人们的就业生态和就业方式和价值观。具体说来，可以从三个方面理解：第一，从就业技能角度说，掌握特定的专业技能（尤其是数字技术应用相关的技能），以及具备机器无法大规模替代的人机交互，创造性等素质将成为人们的就业壁垒，数据表明，目前50%~80%d的就业会在未来被人工智能等技术所替代，而新的工作将产生于不易被数字技术所替代的领域。第二，从就业领域来说，数字化基础服务领域成为就业增长的重要领域，而大量传统产业+数字化的跨界机会应运而生，目前中国就业需求最大的十大行业中，互联网，计算机软件和IT服务占据了其中三个，而未来则能看到所有的就业领域中都需要数字技能，而不仅限于目前的专业领域。第三，由于云计算，LBS，大数据等技术的发展，以及共享经济带来的共享文化生态的推动，产生了平台型就业和创业的新途径，也就是自由人的自由联合，个人或者创业团队拥有技能，生产资料或者某种产品，随时接入任一平台中，实现“按需聚散“的契约履行与价值实现行为，就业生态从稳定的”公司+雇员“的雇佣关系到灵活的”平台+履约人“的转变使得个人不需要通过被组织雇佣获得劳动资格，而是依赖职业身份和专业能力获得社会认可与生存资源。数字原住民一代成为就业主力军，传统的组织+雇员关系面临新世代就业文化的挑战。\n" +
                "\n" +
                "总结下，数字经济的发展使得过去几十年间互联网，计算机等领域发生了革命性的变化，而未来这些变化的核心在于帮助个体，企业以及整个社会发生数字化转型，跨越信息的鸿沟，也就是实现从原子经济向比特经济的转型，所有的实体经济将要实现数字化与比特化生存，对于个人来说，需要看到未来对人才的要求的变化，尤其是机器智能对人的可替代性增强的情况下，需要培养自身的创造能力和跨界技能的储备。对于企业来说，需要在做好自身数字化转型拥抱新技术的同时，也要重塑与人才的关系和打造企业内部的创业开放平台，构建企业为员工赋能的创业环境；而对于政府来说，则要构建适应新时代的大学及职业教育体系，提供更适合未来数字经济的教育体系，而针对数字时代的创新创业浪潮，一方面需要建立更加完善的配套扶持体系来帮助企业发展，另一方面，则要加强监管来应对数字经济发展过程中所出现的风险和问题。未来正在到来，而数字化生存的下半场则会模糊传统产业与互联网产业，整个社会和经济将会发生巨大的变革，我们需要跨越信息的鸿沟，迎接新的数字经济来给每个个体的挑战。").recognition(stopRecognition);


        // 取得学习到的topn新词,返回前10个。这里如果设置为0则返回全部
        System.out.println(learnTool.getTopTree(5));

        // 只取得词性为Nature.NR的新词
        System.out.println(learnTool.getTopTree(0, Nature.NW));//效果比较好
    }//学习新词的测试

    @Test
    public void dicTest() throws Exception {
        //DicLibrary.insert(DicLibrary.DEFAULT, "半监督学习", "n", 1000);
        StopRecognition filter = new StopRecognition();
        List<String> lines = FileUtils.readLines(new File("stopLibrary.dic"),"utf-8");
        filter.insertStopWords(lines);
        String text = "半监督学习是一种智能的学习方案，不然是什么呢？";
        Result result = NlpAnalysis.parse(text).recognition(filter);
        System.out.println(result);

    }//停用词插入测试

    @Test
    public void insertTest() {
        DicLibrary.insert(DicLibrary.DEFAULT, "增加新词", "我是词性", 1000);
        Result parse = DicAnalysis.parse("这是用户自定义词典增加新词的例子");
        System.out.println(parse);
        boolean flag = false;
        for (Term term : parse) {
            flag = flag || "增加新词".equals(term.getName());
        }
        Assert.assertTrue(flag);
    }//dic插入测试

    @Test
    public void StopLibraryTest() throws IOException {
        List<String> lines = FileUtils.readLines(new File("src/main/resources/stopLibrary.dic"),"utf-8");
        StopRecognition stopRecognition = new StopRecognition();
        stopRecognition.insertStopWords(lines);//加载停用词
        stopRecognition.insertStopNatures("m");
        stopRecognition.insertStopNatures("v");
        stopRecognition.insertStopNatures("d");
        List<String> file = FileUtils.readLines(new File("result.txt"),"utf-8");
        for (String s:file
             ) {
            Result result = NlpAnalysis.parse(s).recognition(stopRecognition);
            FileUtils.write(new File("wordResult.txt"),result.toStringWithOutNature(" "),"utf-8",true);
            FileUtils.write(new File("wordResult.txt"),"\n","utf-8",true);

        }
    }


}