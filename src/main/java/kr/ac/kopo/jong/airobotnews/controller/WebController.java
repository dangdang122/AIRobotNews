package kr.ac.kopo.jong.airobotnews.controller;

import kr.ac.kopo.jong.airobotnews.domain.Member;
import kr.ac.kopo.jong.airobotnews.service.MemberService;
import jakarta.servlet.http.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Controller
@RequiredArgsConstructor
public class WebController {
    private final MemberService memberService;

    private List<String[]> getNewsList() {
        List<String[]> news = new ArrayList<>();
        news.add(new String[]{"휴머노이드 상용화", "가정용 휴머노이드 로봇이 2027년 시장 출시를 앞두고 있습니다.", "글로벌 테크 기업들이 2027년 상반기 출시를 목표로 개발 중인 차세대 가정용 휴머노이드 로봇의 양산 및 판매 계획을 전격 발표했습니다. 이번에 시연된 양산형 모델은 최신 멀티모달 AI를 탑재하여, 단순히 정해진 동선을 걷는 것을 넘어 '식기세척기에 그릇 넣기', '바닥에 떨어진 옷가지 분류 및 세탁기 투입' 등 복잡한 비정형 가사 노동을 완벽하게 수행합니다. 예상 출고가는 프리미엄 자동차와 비슷한 3천만 원대로 책정되었으며, 특히 독거노인의 쓰러짐을 초 단위로 감지해 응급실에 자동 연결하는 '실버 안심 케어' 기능이 기본 탑재되어 관련 업계의 판도를 뒤흔들 것으로 전망됩니다.", "humanoid.png"});
        news.add(new String[]{"AI 의학 진단", "AI가 MRI 분석으로 암 조기 발견율 95%를 달성했습니다.", "국내 주요 대학병원 공동 연구진이 개발한 의료 진단용 초거대 AI가 임상 시험에서 췌장암 및 폐암 조기 발견율 95.4%라는 경이적인 수치를 기록하며 식약처의 신속 승인을 받았습니다. 이 AI 시스템은 지난 10년간 누적된 500만 건 이상의 고해상도 MRI 및 CT 영상을 딥러닝으로 학습하여, 전문의의 육안으로는 판독이 불가능한 1mm 이하의 미세 종양 씨앗까지 3초 만에 찾아냅니다. 의료계는 이번 도입을 통해 오진 및 뒤늦은 발견으로 인한 사망률을 획기적으로 낮추는 것은 물론, 불필요한 재검사 비용을 줄여 건강보험 재정 건전성에도 크게 기여할 것으로 기대하고 있습니다.", "medical_ai.png"});
        news.add(new String[]{"자율주행 택시", "서울 도심에서 완전 자율주행 택시의 심야 운행이 시작되었습니다.", "어젯밤 11시를 기점으로 강남, 서초, 여의도 등 서울 도심 주요 권역에서 운전대가 아예 없는 '레벨 4' 완전 자율주행 택시 100대가 정식 영업에 돌입했습니다. 차량 지붕에 장착된 360도 라이다(LiDAR) 센서와 교통관제센터의 6G 통신망이 실시간으로 연동되어, 무단횡단 보행자나 킥보드의 돌발 출현 같은 예측 불가능한 상황에서도 0.1초 만에 안전 제동을 걸 수 있습니다. 이용 요금은 기존 일반 택시보다 20% 저렴하게 책정되었으며, 승차 거부 없이 24시간 배차가 가능해 고질적인 심야 시간대 택시 대란을 근본적으로 해결할 구원투수로 평가받고 있습니다.", "auto_taxi.png"});
        news.add(new String[]{"로봇 공학의 미래", "소프트 로봇 기술이 접목된 유연한 로봇 팔이 정밀 수술에 도입되었습니다.", "금속 관절 대신 인공 근육과 하이드로젤 등 유연한 신소재로 제작된 '소프트 수술 로봇'이 세계 최초로 국내 신경외과 뇌혈관 문합 수술에 투입되어 성공적인 결과를 냈습니다. 기존의 강체(딱딱한) 로봇은 좁은 장기 사이를 비집고 들어갈 때 주변 조직에 미세한 손상을 줄 위험이 있었으나, 이 소프트 로봇은 문어의 촉수처럼 자유자재로 휘어지며 목표 환부에 부드럽게 접근합니다. 수술을 집도한 의료진은 \"사람의 손떨림을 완전히 보정할 뿐만 아니라, 혈관 내벽을 건드리지 않고 0.01mm 굵기의 실을 꿰맬 수 있어 수술 후 환자 회복 속도가 기존 대비 2배 이상 빠르다\"고 밝혔습니다.", "soft_robot.png"});
        news.add(new String[]{"스마트 팜 AI", "AI 스마트 팜이 물 소비량을 50% 절감하며 생산성을 높였습니다.", "전북 김제시 스마트 팜 혁신밸리에 시범 적용된 'AI 관제 시스템'이 기상청 슈퍼컴퓨터와 실시간으로 연동되어 농업의 패러다임을 바꾸고 있습니다. 이 시스템은 일조량, 습도 변화, 병해충 이동 경로를 AI가 선제적으로 예측하여 환풍기 개폐와 영양액 투입 농도를 스스로 결정합니다. 그 결과 작물 생산량은 작년 대비 32% 폭증한 반면, 증발하는 수분량까지 계산해 핀포인트로 물을 분사하는 기술 덕분에 전체 농업용수 소비량은 50%나 급감했습니다. 극심한 가뭄과 이상 기후 속에서도 안정적인 식량 안보를 확보할 수 있는 궁극의 해결책으로 전 세계 농업계의 이목이 쏠리고 있습니다.", "smart_farm.png"});
        news.add(new String[]{"로봇 배달원", "고층 아파트 단지 내에서 자율주행 배달 로봇이 서비스를 본격화합니다.", "3천 세대가 넘는 수도권의 한 대형 아파트 단지에서 자율주행 배달 로봇 '딜리버 팟' 50대가 전면 도입되어 아파트 풍경을 바꾸고 있습니다. 택배 기사가 단지 입구 중앙 스테이션에 물품을 일괄 하차하면, 로봇들이 각 동의 아파트 중앙 서버와 무선으로 통신하며 스스로 엘리베이터를 호출하고 탑승해 입주민의 현관문 앞까지 물건을 배송합니다. 도난 방지용 안면 인식 잠금장치가 장착되어 분실 위험을 원천 차단했으며, 단지 내 지상 출입 차량이 전면 통제됨에 따라 어린이 교통사고 위험도 사라져 입주민들의 만족도가 최고조에 달하고 있습니다.", "delivery_robot.png"});
        news.add(new String[]{"AI 언어 모델", "초거대 AI가 실시간 동시통역으로 언어 장벽을 허물었습니다.", "어제 스위스 다보스 포럼에서 각국 정상들의 귀에 꽂힌 작은 무선 이어폰 하나가 세상을 놀라게 했습니다. 글로벌 IT 기업이 공개한 초거대 AI 기반 실시간 동시통역 엔진이 120개국 언어를 지연시간 0.2초 미만으로 완벽하게 번역해 낸 것입니다. 단순한 단어의 치환을 넘어, 발화자의 억양, 현지 특유의 은어나 관용구, 심지어 농담의 뉘앙스까지 파악해 가장 자연스러운 문장으로 재창조하여 전달합니다. 전문가들은 이 기술이 상용화됨에 따라 외국어 학습의 필요성에 대한 근본적인 질문이 던져졌으며, 수십조 원 규모의 글로벌 통번역 시장이 빠르게 재편될 것이라고 입을 모았습니다.", "ai_translation.png"});
        news.add(new String[]{"재활 보조 로봇", "근력 보조 웨어러블 로봇이 고령자의 재활을 돕습니다.", "하반신 마비 환자나 고령자의 옷 안에 입을 수 있는 '초경량 인공근육 슈트'가 전국 국립 재활원에 보급되기 시작했습니다. 총중량 1.5kg에 불과한 이 웨어러블 로봇은 착용자의 뇌파와 근육의 미세한 전기 신호를 0.05초 단위로 감지하여, 다리를 들어 올리려는 의도를 파악하는 즉시 모터와 와이어를 통해 강력한 보행 보조력을 제공합니다. 휠체어에만 의존하던 중증 환자들이 보행 보조기구 없이 계단을 오르내리는 기적 같은 임상 결과가 연일 보고되고 있으며, 정부는 내년부터 이 기기에 대한 건강보험 혜택을 전면 적용하여 초고령화 사회의 필수 복지 인프라로 안착시킬 계획입니다.", "rehab_robot.png"});
        news.add(new String[]{"AI 아트 제너레이터", "생성형 AI가 디자인한 작품이 국제 공모전에서 입상했습니다.", "인간의 고유 영역으로 여겨졌던 순수 예술계가 발칵 뒤집혔습니다. 어제 폐막한 세계 최고 권위의 '현대 산업 디자인 비엔날레'에서 대상을 차지한 설치 미술 작품이 사실은 프롬프트 엔지니어 한 명과 이미지 생성형 AI가 단 3시간 만에 공동 작업한 결과물로 밝혀졌기 때문입니다. 심사위원단조차 \"인간의 붓 터치와 공간 감각을 완전히 초월한 경이로운 질감 표현\"이라며 극찬했던 터라 그 충격은 더욱 컸습니다. 예술계 일각에서는 '알고리즘의 표절 조각보'라며 수상을 취소해야 한다는 강력한 반발이 일고 있으나, 주최 측은 \"AI를 도구로 활용한 기획력 역시 새로운 시대의 창작\"이라며 수상을 유지해 당분간 거센 논란이 이어질 전망입니다.", "ai_art.png"});
        news.add(new String[]{"우주 탐사 로봇", "달 표면 희토류 탐사 로봇이 성공적으로 착륙했습니다.", "한국 시간으로 오늘 새벽, 인류 최초의 상업용 무인 달 탐사 로버 '루나 마이너-1'이 달 남극 섀클턴 크레이터 근처에 안착하는 데 성공했습니다. 이 자율주행 로버는 초정밀 레이저 분광기를 장착하여, 스마트폰과 전기차 배터리의 핵심 원료이나 지구에서는 고갈 위기에 처한 희토류와 네오디뮴 광맥을 집중 탐사합니다. 이미 착륙 후 첫 번째 드릴링(시추)을 통해 상당량의 희귀 광물이 포함된 암석층을 확인했다는 데이터가 지구로 전송되었습니다. 이번 임무의 성공은 천문학적인 비용이 드는 달 기지 건설의 경제적 타당성을 증명하는 신호탄으로, 각국의 우주 자원 확보 총성 없는 전쟁에 불을 지폈습니다.", "space_rover.png"});
        news.add(new String[]{"교육용 로봇 AI", "AI 교사가 학생 학습 데이터로 최적 커리큘럼을 제공합니다.", "시범 운영 중인 서울의 한 초등학교에서는 교실마다 배치된 로봇 조교 '에듀-봇'이 교사들을 대신해 학생들의 개별 지도를 맡고 있습니다. 학생들의 태블릿 PC 화면 터치 속도, 시선 처리, 오답 패턴 등 수만 개의 데이터를 실시간으로 분석한 AI는, 수학에 흥미를 잃은 학생에게는 좋아하는 게임 캐릭터를 활용한 시각적 문제를 출제하고 진도가 빠른 학생에게는 심화 탐구 과제를 던져줍니다. 도입 6개월 만에 해당 학교 학생들의 기초 학력 미달 비율이 제로(0%)로 떨어졌으며, 사교육 격차를 공교육의 AI 도입으로 해결할 수 있다는 희망적인 데이터가 나오면서 교육부의 전면 도입 시계가 빨라지고 있습니다.", "edu_robot.png"});
        news.add(new String[]{"해양 정화 로봇", "자율 해양 정화 로봇이 태평양 쓰레기 섬 제거를 시작했습니다.", "한반도 면적의 7배에 달해 이른바 '태평양 거대 쓰레기 지대(GPGP)'로 불리는 해역에 10만 톤 급 무인 자율 해양 정화 로봇 선단이 닻을 올렸습니다. 거대한 고래의 입을 형상화한 이 무인 로봇들은 100% 태양광과 파도의 힘으로만 발전하며 망망대해를 24시간 자율 항해합니다. 뱃머리에 달린 AI 수중 카메라가 물고기 떼와 미세 플라스틱 쓰레기를 정확히 구분해 내어, 해양 생태계의 파괴 없이 쓰레기만을 거대한 컨베이어 벨트로 집어삼킵니다. 환경 단체들은 하루 평균 50톤씩 쏟아져 나오는 플라스틱 폐기물들이 이 선단의 활약으로 10년 안에 절반 이하로 줄어들 것이라며 전례 없는 기대감을 표하고 있습니다.", "ocean_cleanup.png"});
        return news;
    }

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null) model.addAttribute("member", session.getAttribute("loginMember"));

        List<String[]> news = getNewsList();
        Collections.shuffle(news);
        model.addAttribute("newsList", news.subList(0, 3));
        return "index";
    }

    @GetMapping("/news/{title}")
    public String newsDetail(@PathVariable String title, Model model) {
        String[] targetNews = getNewsList().stream()
                .filter(n -> n[0].equals(title))
                .findFirst()
                .orElse(null);
        model.addAttribute("news", targetNews);
        return "detail";
    }

    @GetMapping("/login")
    public String loginForm() { return "login"; }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpServletRequest request) {
        Member loginMember = memberService.login(email, password);
        if (loginMember == null) {
            String msg = URLEncoder.encode("아이디 또는 비밀번호가 틀렸습니다.", StandardCharsets.UTF_8);
            return "redirect:/login?alert=" + msg;
        }
        request.getSession().setAttribute("loginMember", loginMember);
        String msg = URLEncoder.encode("로그인 성공!", StandardCharsets.UTF_8);
        return "redirect:/?alert=" + msg;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/register")
    public String register(@RequestParam String email, @RequestParam String password) {
        memberService.register(email, password);
        String msg = URLEncoder.encode("회원가입 완료! 로그인해주세요.", StandardCharsets.UTF_8);
        return "redirect:/login?alert=" + msg;
    }
}