package bt.storage;

/**
 * Creates a Vector
 * 
 * @author Derrick Lockwood 
 * @version Feb 26
 */
public class BTVector
{
    private double i;
    private double j;
    private static final double atandata[] = {-1.5083775167989393, -1.5082556844408677, -1.5081333761787898, -1.5080105892224516, -1.5078873207597714, -1.5077635679566286, -1.5076393279566467, -1.5075145978809743, -1.5073893748280647, -1.5072636558734516, -1.5071374380695226, -1.507010718445291, -1.5068834940061626, -1.5067557617337017, -1.5066275185853943, -1.5064987614944068, -1.5063694873693432, -1.5062396930939994, -1.5061093755271147, -1.5059785315021177, -1.505847157826874, -1.5057152512834255, -1.5055828086277312, -1.5054498265894019, -1.5053163018714317, -1.505182231149929, -1.5050476110738407, -1.5049124382646746, -1.5047767093162199, -1.504640420794261, -1.5045035692362905, -1.5043661511512176, -1.5042281630190728, -1.5040896012907092, -1.5039504623875, -1.5038107427010319, -1.503670438592796, -1.5035295463938727, -1.5033880624046145, -1.5032459828943239, -1.5031033041009279, -1.5029600222306472, -1.5028161334576626, -1.5026716339237762, -1.502526519738069, -1.5023807869765542, -1.5022344316818241, -1.5020874498626964, -1.501939837493852, -1.5017915905154702, -1.5016427048328593, -1.5014931763160817, -1.5013430007995745, -1.5011921740817649, -1.5010406919246815, -1.5008885500535596, -1.5007357441564413, -1.5005822698837714, -1.5004281228479872, -1.5002732986231035, -1.500117792744291, -1.4999616007074503, -1.4998047179687803, -1.4996471399443403, -1.4994888620096063, -1.499329879499022, -1.4991701877055434, -1.4990097818801775, -1.4988486572315145, -1.498686808925254, -1.4985242320837255, -1.498360921785401, -1.498196873064402, -1.4980320809100003, -1.4978665402661109, -1.4977002460307784, -1.4975331930556572, -1.4973653761454833, -1.49719679005754, -1.4970274295011163, -1.4968572891369563, -1.4966863635767031, -1.4965146473823339, -1.4963421350655874, -1.4961688210873838, -1.4959946998572358, -1.4958197657326522, -1.4956440130185331, -1.4954674359665565, -1.495290028774556, -1.4951117855858904, -1.4949327004888044, -1.4947527675157795, -1.4945719806428763, -1.4943903337890676, -1.4942078208155625, -1.4940244355251187, -1.493840171661348, -1.4936550229080106, -1.4934689828882972, -1.493282045164105, -1.4930942032352992, -1.492905450538967, -1.4927157804486586, -1.4925251862736186, -1.492333661258005, -1.492141198580098, -1.4919477913514967, -1.491753432616304, -1.4915581153502997, -1.4913618324601012, -1.4911645767823125, -1.4909663410826592, -1.4907671180551127, -1.4905669003209994, -1.490365680428098, -1.4901634508497228, -1.4899602039837936, -1.4897559321518907, -1.4895506275982973, -1.4893442824890257, -1.4891368889108305, -1.4889284388702053, -1.4887189242923657, -1.4885083370202148, -1.4882966688132953, -1.4880839113467237, -1.487870056210109, -1.4876550949064553, -1.4874390188510456, -1.4872218193703097, -1.4870034877006761, -1.486784014987402, -1.4865633922833894, -1.4863416105479796, -1.4861186606457306, -1.4858945333451747, -1.4856692193175562, -1.48544270913555, -1.4852149932719598, -1.4849860620983946, -1.484755905883925, -1.4845245147937196, -1.4842918788876556, -1.4840579881189115, -1.4838228323325346, -1.4835864012639863, -1.4833486845376636, -1.4831096716653962, -1.4828693520449212, -1.4826277149583307, -1.4823847495704947, -1.482140444927459, -1.4818947899548167, -1.4816477734560505, -1.4813993841108521, -1.48114961047341, -1.48089844097067, -1.480645863900568, -1.4803918674302312, -1.4801364395941514, -1.4798795682923263, -1.4796212412883691, -1.4793614462075886, -1.4791001705350335, -1.478837401613507, -1.4785731266415447, -1.47830733267136, -1.478040006606753, -1.4777711352009848, -1.4775007050546152, -1.4772287026133013, -1.4769551141655601, -1.476679925840492, -1.4764031236054633, -1.4761246932637502, -1.4758446204521403, -1.4755628906384926, -1.475279489119254, -1.4749944010169336, -1.4747076112775297, -1.4744191046679138, -1.4741288657731668, -1.4738368789938667, -1.473543128543331, -1.4732475984448048, -1.4729502725286039, -1.4726511344292013, -1.4723501675822634, -1.4720473552216338, -1.4717426803762577, -1.4714361258670554, -1.4711276743037347, -1.4708173080815463, -1.4705050093779795, -1.4701907601493962, -1.4698745421276027, -1.4695563368163587, -1.469236125487819, -1.468913889178911, -1.468589608687643, -1.4682632645693434, -1.467934837132828, -1.4676043064364963, -1.4672716522843523, -1.4669368542219503, -1.466599891532263, -1.466260743231469, -1.4659193880646628, -1.4655758045014777, -1.4652299707316272, -1.4648818646603587, -1.4645314639038178, -1.464178745784324, -1.463823687325552, -1.4634662652476191, -1.463106455962076, -1.4627442355667972, -1.4623795798407722, -1.4620124642387895, -1.4616428638860188, -1.4612707535724807, -1.4608961077474072, -1.4605189005134882, -1.460139105621001, -1.4597566964618214, -1.4593716460633122, -1.458983927082086, -1.4585935117976423, -1.4582003721058714, -1.4578044795124259, -1.457405805125953, -1.4570043196511886, -1.4565999933819045, -1.4561927961937111, -1.4557826975367065, -1.4553696664279718, -1.4549536714439082, -1.4545346807124102, -1.4541126619048736, -1.4536875822280324, -1.45325940841562, -1.4528281067198525, -1.4523936429027269, -1.4519559822271315, -1.4515150894477633, -1.4510709288018468, -1.4506234639996505, -1.4501726582147938, -1.4497184740743425, -1.4492608736486823, -1.4487998184411703, -1.448335269377555, -1.4478671867951591, -1.4473955304318202, -1.446920259414583, -1.446441332248135, -1.445958706802982, -1.44547234030335, -1.4449821893148174, -1.4444882097316563, -1.4439903567638894, -1.4434885849240424, -1.442982848013593, -1.442473099109102, -1.4419592905480227, -1.441441373914177, -1.4409193000228877, -1.4403930189057632, -1.4398624797951187, -1.4393276311080276, -1.4387884204299923, -1.4382447944982226, -1.4376966991845126, -1.437144079477703, -1.436586879465718, -1.4360250423171654, -1.4354585102624873, -1.434887224574646, -1.4343111255493364, -1.433730152484709, -1.433144243660587, -1.432553336317168, -1.431957366633192, -1.431356269703559, -1.4307499795163845, -1.4301384289294732, -1.4295215496461924, -1.4288992721907328, -1.428271525882732, -1.4276382388112479, -1.4269993378080548, -1.4263547484202526, -1.4257043948821575, -1.4250482000864593, -1.4243860855546202, -1.423717971406494, -1.423043776329139, -1.4223634175448017, -1.4216768107780458, -1.4209838702219992, -1.4202845085036921, -1.419578636648456, -1.4188661640433569, -1.4181469983996315, -1.4174210457140919, -1.4166882102294702, -1.4159483943936668, -1.415201498817867, -1.4144474222334904, -1.413686061447936, -1.412917311299081, -1.412141064608495, -1.4113572121333302, -1.4105656425168345, -1.409766242237455, -1.4089588955564738, -1.4081434844641338, -1.4073198886242024, -1.4064879853169183, -1.4056476493802699, -1.4047987531495467, -1.4039411663951076, -1.4030747562582988, -1.402199387185467, -1.4013149208599924, -1.4004212161322807, -1.3995181289476382, -1.3986055122719576, -1.397683216015138, -1.396751086952158, -1.3958089686417179, -1.3948567013423687, -1.393894121926032, -1.39292106378882, -1.3919373567590603, -1.3909428270024184, -1.3899372969240174, -1.3889205850674426, -1.3878925060105158, -1.3868528702577214, -1.3858014841291588, -1.3847381496458928, -1.3836626644115646, -1.382574821490126, -1.3814744092795461, -1.3803612113813424, -1.3792350064657704, -1.378095568132511, -1.3769426647666798, -1.3757760593899753, -1.3745955095067801, -1.373400766945016, -1.372191577691545, -1.3709676817219063, -1.369728812824158, -1.368474698416593, -1.3672050593590819, -1.3659196097577881, -1.3646180567629846, -1.363300100359694, -1.361965433150857, -1.360613740132727, -1.3592446984621644, -1.3578579772154995, -1.3564532371386109, -1.3550301303878542, -1.3535883002614535, -1.3521273809209546, -1.3506469971023198, -1.349146763816219, -1.3476262860370576, -1.346085158380254, -1.3445229647672612, -1.342939278077797, -1.3413336597887242, -1.3397056595989996, -1.3380548150400715, -1.3363806510710858, -1.3346826796582207, -1.332960399337446, -1.3312132947599544, -1.3294408362194927, -1.3276424791607622, -1.3258176636680326, -1.3239658139330621, -1.3220863377013738, -1.3201786256958834, -1.3182420510168371, -1.3162759685169476, -1.314279714150573, -1.3122526042957148, -1.3101939350475558, -1.3081029814821874, -1.3059789968891078, -1.3038212119709955, -1.3016288340091962, -1.2994010459932608, -1.2971370057128062, -1.2948358448098625, -1.2924966677897853, -1.2901185509887085, -1.287700541495401, -1.285241656025288, -1.2827408797442708, -1.2801971650398616, -1.2776094302370145, -1.2749765582558992, -1.2722973952087173, -1.2695707489325108, -1.266795387454752, -1.2639700373883394, -1.2610933822524404, -1.2581640607154498, -1.2551806647561303, -1.252141737738804, -1.2490457723982544, -1.2458912087297775, -1.2426764317795913, -1.2393997693305772, -1.236059489478082, -1.232653798090249, -1.2291808361470895, -1.2256386769522283, -1.2220253232109897, -1.2183387039681923, -1.2145766713987465, -1.2107369974438442, -1.2068173702852525, -1.2028153906499124, -1.1987285679367763, -1.1945543161575234, -1.1902899496825317, -1.1859326787832343, -1.1814796049617557, -1.1769277160585352, -1.1722738811284763, -1.1675148450760604, -1.1626472230398073, -1.1576674945164953, -1.1525719972156676, -1.1473569206351775, -1.14201829934888, -1.1365520059980956, -1.1309537439791604, -1.1252190398203148, -1.1193432352423422, -1.1133214788988715, -1.1071487177940904, -1.1008196883778887, -1.09432890732119, -1.087670661977563, -1.0808390005411683, -1.0738277219158432, -1.0666303653157436, -1.059240199624591, -1.0516502125483738, -1.043853099605467, -1.0358412530088001, -1.0276067505070687, -1.0191413442663497, -1.0104364498900535, -1.0014831356942346, -0.9922721123771914, -0.982793723247329, -0.9730379352018146, -0.9629943306809362, -0.9526521008597094, -0.9420000403794637, -0.931026543968271, -0.9197196053504169, -0.908066818901905, -0.8960553845713439, -0.8836721166534575, -0.870903457075653, -0.8577354939360433, -0.844153986113171, -0.8301443948520639, -0.8156919233162234, -0.8007815651780434, -0.7853981633974483, -0.7695264804056583, -0.7531512809621944, -0.7362574289814281, -0.7188299996216245, -0.7008544078844502, -0.6823165548747481, -0.6632029927060933, -0.6435011087932844, -0.6231993299340659, -0.6022873461349642, -0.5807563535676704, -0.5585993153435624, -0.5358112379604637, -0.5123894603107377, -0.48833395105640554, -0.4636476090008061, -0.43833655985795783, -0.4124104415973873, -0.38588266939807375, -0.3587706702705722, -0.3310960767041321, -0.3028848683749714, -0.2741674511196588, -0.24497866312686414, -0.21535769969773805, -0.18534794999569476, -0.15499674192394097, -0.12435499454676144, -0.09347678115858947, -0.06241880999595735, -0.031239833430268277, 0.0, 0.031239833430268277, 0.06241880999595735, 0.09347678115858947, 0.12435499454676144, 0.15499674192394097, 0.18534794999569476, 0.21535769969773805, 0.24497866312686414, 0.2741674511196588, 0.3028848683749714, 0.3310960767041321, 0.3587706702705722, 0.38588266939807375, 0.4124104415973873, 0.43833655985795783, 0.4636476090008061, 0.48833395105640554, 0.5123894603107377, 0.5358112379604637, 0.5585993153435624, 0.5807563535676704, 0.6022873461349642, 0.6231993299340659, 0.6435011087932844, 0.6632029927060933, 0.6823165548747481, 0.7008544078844502, 0.7188299996216245, 0.7362574289814281, 0.7531512809621944, 0.7695264804056583, 0.7853981633974483, 0.8007815651780434, 0.8156919233162234, 0.8301443948520639, 0.844153986113171, 0.8577354939360433, 0.870903457075653, 0.8836721166534575, 0.8960553845713439, 0.908066818901905, 0.9197196053504169, 0.931026543968271, 0.9420000403794637, 0.9526521008597094, 0.9629943306809362, 0.9730379352018146, 0.982793723247329, 0.9922721123771914, 1.0014831356942346, 1.0104364498900535, 1.0191413442663497, 1.0276067505070687, 1.0358412530088001, 1.043853099605467, 1.0516502125483738, 1.059240199624591, 1.0666303653157436, 1.0738277219158432, 1.0808390005411683, 1.087670661977563, 1.09432890732119, 1.1008196883778887, 1.1071487177940904, 1.1133214788988715, 1.1193432352423422, 1.1252190398203148, 1.1309537439791604, 1.1365520059980956, 1.14201829934888, 1.1473569206351775, 1.1525719972156676, 1.1576674945164953, 1.1626472230398073, 1.1675148450760604, 1.1722738811284763, 1.1769277160585352, 1.1814796049617557, 1.1859326787832343, 1.1902899496825317, 1.1945543161575234, 1.1987285679367763, 1.2028153906499124, 1.2068173702852525, 1.2107369974438442, 1.2145766713987465, 1.2183387039681923, 1.2220253232109897, 1.2256386769522283, 1.2291808361470895, 1.232653798090249, 1.236059489478082, 1.2393997693305772, 1.2426764317795913, 1.2458912087297775, 1.2490457723982544, 1.252141737738804, 1.2551806647561303, 1.2581640607154498, 1.2610933822524404, 1.2639700373883394, 1.266795387454752, 1.2695707489325108, 1.2722973952087173, 1.2749765582558992, 1.2776094302370145, 1.2801971650398616, 1.2827408797442708, 1.285241656025288, 1.287700541495401, 1.2901185509887085, 1.2924966677897853, 1.2948358448098625, 1.2971370057128062, 1.2994010459932608, 1.3016288340091962, 1.3038212119709955, 1.3059789968891078, 1.3081029814821874, 1.3101939350475558, 1.3122526042957148, 1.314279714150573, 1.3162759685169476, 1.3182420510168371, 1.3201786256958834, 1.3220863377013738, 1.3239658139330621, 1.3258176636680326, 1.3276424791607622, 1.3294408362194927, 1.3312132947599544, 1.332960399337446, 1.3346826796582207, 1.3363806510710858, 1.3380548150400715, 1.3397056595989996, 1.3413336597887242, 1.342939278077797, 1.3445229647672612, 1.346085158380254, 1.3476262860370576, 1.349146763816219, 1.3506469971023198, 1.3521273809209546, 1.3535883002614535, 1.3550301303878542, 1.3564532371386109, 1.3578579772154995, 1.3592446984621644, 1.360613740132727, 1.361965433150857, 1.363300100359694, 1.3646180567629846, 1.3659196097577881, 1.3672050593590819, 1.368474698416593, 1.369728812824158, 1.3709676817219063, 1.372191577691545, 1.373400766945016, 1.3745955095067801, 1.3757760593899753, 1.3769426647666798, 1.378095568132511, 1.3792350064657704, 1.3803612113813424, 1.3814744092795461, 1.382574821490126, 1.3836626644115646, 1.3847381496458928, 1.3858014841291588, 1.3868528702577214, 1.3878925060105158, 1.3889205850674426, 1.3899372969240174, 1.3909428270024184, 1.3919373567590603, 1.39292106378882, 1.393894121926032, 1.3948567013423687, 1.3958089686417179, 1.396751086952158, 1.397683216015138, 1.3986055122719576, 1.3995181289476382, 1.4004212161322807, 1.4013149208599924, 1.402199387185467, 1.4030747562582988, 1.4039411663951076, 1.4047987531495467, 1.4056476493802699, 1.4064879853169183, 1.4073198886242024, 1.4081434844641338, 1.4089588955564738, 1.409766242237455, 1.4105656425168345, 1.4113572121333302, 1.412141064608495, 1.412917311299081, 1.413686061447936, 1.4144474222334904, 1.415201498817867, 1.4159483943936668, 1.4166882102294702, 1.4174210457140919, 1.4181469983996315, 1.4188661640433569, 1.419578636648456, 1.4202845085036921, 1.4209838702219992, 1.4216768107780458, 1.4223634175448017, 1.423043776329139, 1.423717971406494, 1.4243860855546202, 1.4250482000864593, 1.4257043948821575, 1.4263547484202526, 1.4269993378080548, 1.4276382388112479, 1.428271525882732, 1.4288992721907328, 1.4295215496461924, 1.4301384289294732, 1.4307499795163845, 1.431356269703559, 1.431957366633192, 1.432553336317168, 1.433144243660587, 1.433730152484709, 1.4343111255493364, 1.434887224574646, 1.4354585102624873, 1.4360250423171654, 1.436586879465718, 1.437144079477703, 1.4376966991845126, 1.4382447944982226, 1.4387884204299923, 1.4393276311080276, 1.4398624797951187, 1.4403930189057632, 1.4409193000228877, 1.441441373914177, 1.4419592905480227, 1.442473099109102, 1.442982848013593, 1.4434885849240424, 1.4439903567638894, 1.4444882097316563, 1.4449821893148174, 1.44547234030335, 1.445958706802982, 1.446441332248135, 1.446920259414583, 1.4473955304318202, 1.4478671867951591, 1.448335269377555, 1.4487998184411703, 1.4492608736486823, 1.4497184740743425, 1.4501726582147938, 1.4506234639996505, 1.4510709288018468, 1.4515150894477633, 1.4519559822271315, 1.4523936429027269, 1.4528281067198525, 1.45325940841562, 1.4536875822280324, 1.4541126619048736, 1.4545346807124102, 1.4549536714439082, 1.4553696664279718, 1.4557826975367065, 1.4561927961937111, 1.4565999933819045, 1.4570043196511886, 1.457405805125953, 1.4578044795124259, 1.4582003721058714, 1.4585935117976423, 1.458983927082086, 1.4593716460633122, 1.4597566964618214, 1.460139105621001, 1.4605189005134882, 1.4608961077474072, 1.4612707535724807, 1.4616428638860188, 1.4620124642387895, 1.4623795798407722, 1.4627442355667972, 1.463106455962076, 1.4634662652476191, 1.463823687325552, 1.464178745784324, 1.4645314639038178, 1.4648818646603587, 1.4652299707316272, 1.4655758045014777, 1.4659193880646628, 1.466260743231469, 1.466599891532263, 1.4669368542219503, 1.4672716522843523, 1.4676043064364963, 1.467934837132828, 1.4682632645693434, 1.468589608687643, 1.468913889178911, 1.469236125487819, 1.4695563368163587, 1.4698745421276027, 1.4701907601493962, 1.4705050093779795, 1.4708173080815463, 1.4711276743037347, 1.4714361258670554, 1.4717426803762577, 1.4720473552216338, 1.4723501675822634, 1.4726511344292013, 1.4729502725286039, 1.4732475984448048, 1.473543128543331, 1.4738368789938667, 1.4741288657731668, 1.4744191046679138, 1.4747076112775297, 1.4749944010169336, 1.475279489119254, 1.4755628906384926, 1.4758446204521403, 1.4761246932637502, 1.4764031236054633, 1.476679925840492, 1.4769551141655601, 1.4772287026133013, 1.4775007050546152, 1.4777711352009848, 1.478040006606753, 1.47830733267136, 1.4785731266415447, 1.478837401613507, 1.4791001705350335, 1.4793614462075886, 1.4796212412883691, 1.4798795682923263, 1.4801364395941514, 1.4803918674302312, 1.480645863900568, 1.48089844097067, 1.48114961047341, 1.4813993841108521, 1.4816477734560505, 1.4818947899548167, 1.482140444927459, 1.4823847495704947, 1.4826277149583307, 1.4828693520449212, 1.4831096716653962, 1.4833486845376636, 1.4835864012639863, 1.4838228323325346, 1.4840579881189115, 1.4842918788876556, 1.4845245147937196, 1.484755905883925, 1.4849860620983946, 1.4852149932719598, 1.48544270913555, 1.4856692193175562, 1.4858945333451747, 1.4861186606457306, 1.4863416105479796, 1.4865633922833894, 1.486784014987402, 1.4870034877006761, 1.4872218193703097, 1.4874390188510456, 1.4876550949064553, 1.487870056210109, 1.4880839113467237, 1.4882966688132953, 1.4885083370202148, 1.4887189242923657, 1.4889284388702053, 1.4891368889108305, 1.4893442824890257, 1.4895506275982973, 1.4897559321518907, 1.4899602039837936, 1.4901634508497228, 1.490365680428098, 1.4905669003209994, 1.4907671180551127, 1.4909663410826592, 1.4911645767823125, 1.4913618324601012, 1.4915581153502997, 1.491753432616304, 1.4919477913514967, 1.492141198580098, 1.492333661258005, 1.4925251862736186, 1.4927157804486586, 1.492905450538967, 1.4930942032352992, 1.493282045164105, 1.4934689828882972, 1.4936550229080106, 1.493840171661348, 1.4940244355251187, 1.4942078208155625, 1.4943903337890676, 1.4945719806428763, 1.4947527675157795, 1.4949327004888044, 1.4951117855858904, 1.495290028774556, 1.4954674359665565, 1.4956440130185331, 1.4958197657326522, 1.4959946998572358, 1.4961688210873838, 1.4963421350655874, 1.4965146473823339, 1.4966863635767031, 1.4968572891369563, 1.4970274295011163, 1.49719679005754, 1.4973653761454833, 1.4975331930556572, 1.4977002460307784, 1.4978665402661109, 1.4980320809100003, 1.498196873064402, 1.498360921785401, 1.4985242320837255, 1.498686808925254, 1.4988486572315145, 1.4990097818801775, 1.4991701877055434, 1.499329879499022, 1.4994888620096063, 1.4996471399443403, 1.4998047179687803, 1.4999616007074503, 1.500117792744291, 1.5002732986231035, 1.5004281228479872, 1.5005822698837714, 1.5007357441564413, 1.5008885500535596, 1.5010406919246815, 1.5011921740817649, 1.5013430007995745, 1.5014931763160817, 1.5016427048328593, 1.5017915905154702, 1.501939837493852, 1.5020874498626964, 1.5022344316818241, 1.5023807869765542, 1.502526519738069, 1.5026716339237762, 1.5028161334576626, 1.5029600222306472, 1.5031033041009279, 1.5032459828943239, 1.5033880624046145, 1.5035295463938727, 1.503670438592796, 1.5038107427010319, 1.5039504623875, 1.5040896012907092, 1.5042281630190728, 1.5043661511512176, 1.5045035692362905, 1.504640420794261, 1.5047767093162199, 1.5049124382646746, 1.5050476110738407, 1.505182231149929, 1.5053163018714317, 1.5054498265894019, 1.5055828086277312, 1.5057152512834255, 1.505847157826874, 1.5059785315021177, 1.5061093755271147, 1.5062396930939994, 1.5063694873693432, 1.5064987614944068, 1.5066275185853943, 1.5067557617337017, 1.5068834940061626, 1.507010718445291, 1.5071374380695226, 1.5072636558734516, 1.5073893748280647, 1.5075145978809743, 1.5076393279566467, 1.5077635679566286, 1.5078873207597714, 1.5080105892224516, 1.5081333761787898, 1.5082556844408677};
    

    /**
     * Constructor for Vector class that uses the terminal form to define a vector
     * 
     * @param I Value of the x of the terminal point
     * @param J Value of the y of the terminal point
     */
    public BTVector (double i, double j)
    {
        this.i = i;
        this.j = j;
    }
    
    /**
     * Rounds a number to the hundreths place. Used only within Vector
     *
     * @param d is the number to round
     * @return The number rounded to the 100ths
     */
    private double roundHundred(double d)
    {
        d = Math.floor(d*100);
        d = d/100;
        return d;
    }
    
    /**
     * Constructor for Vector class that uses the directional and Mag form to define a vector
     * 
     * @param Mag Value of the Mag of the vector
     * @param Angle The direction of the vector
     * @param isDegrees Whether the angle is in degree or radians, true if degrees, false if radians
     */
    public BTVector (double Mag, double Angle, boolean isDegrees)
    {
        double answeri;
        double answerj;
        
        if (isDegrees)
        {
            answeri = Mag*Math.cos(Math.toRadians(Angle));
            answerj = Mag*Math.sin(Math.toRadians(Angle));
        }
        else
        {
            answeri = Mag*Math.cos(Angle);
            answerj = Mag*Math.sin(Angle);
        }
        i = answeri;
        j = answerj;
    }
    
    public double getMagnitude()
    {
        return roundHundred(Math.sqrt((i*i)+(j*j)));
    }
    
    public double getI()
    {
        return i;
    }
    
    public double getJ()
    {
        return j;    
    }
    
    public double getAngleDegreeXAxes()
    {
        double inverseTan;
        inverseTan = BTVector.aTan(j/i);
        inverseTan += Math.PI;
        return roundHundred(Math.toDegrees(inverseTan));   
    }
    
    public double getAngleRadianXAxes()
    {
        double inverseTan;
        inverseTan = BTVector.aTan(j/i);
        inverseTan += Math.PI;
        return roundHundred(inverseTan);
    }
    
    public static BTVector getResultantVector(BTVector v1, BTVector v2)
    {
        BTVector result;
        double resultI;
        double resultV;
        
        resultI = v2.getI() + v1.getI();
        resultV = v2.getJ() + v1.getJ();
        
        result = new BTVector(resultI, resultV);
        return result;
    }
    
    public void setI(double itemp)
    {
        j = itemp;
    }
    
    public void setJ(double jtemp)
    {
        j = jtemp;
    }
    
    public String toString()
    {
        return "Vector: "+i+"i+"+j+"j";
    }
    
    public static double getDotProduct(BTVector v1, BTVector v2)
    {
        double resultI;
        double resultJ;
        
        resultI = v1.getI() * v2.getI();
        resultJ = v1.getJ() * v2.getJ();
        
        return resultI+resultJ;
    }
    public static double getAngleBetweenVector(BTVector v1, BTVector v2, boolean isDegree)
    {
        double answer;
        
        answer = BTVector.aCos(BTVector.getDotProduct(v1,v2)/(v1.getMagnitude()*v2.getMagnitude()));
        if (isDegree)
        {
            answer = Math.toDegrees(answer);
        }
        
        return answer;
    }
    
    public BTVector getUnitVector()
    {
        double resultI;
        double resultJ;
        BTVector result;
        
        resultI = 1*Math.cos(getAngleRadianXAxes());
        resultJ = 1*Math.sin(getAngleRadianXAxes());
        result = new BTVector(resultI, resultJ);
        
        return result;
    }
    
    public BTVector[] getOrthogonalVectors(BTVector w)
    {
        BTVector[] vArray = new BTVector[3];
        BTVector projwV = getProjection(w);
        BTVector v = new BTVector(i,j);
        BTVector secondVector;
        
        secondVector = BTVector.subtractVector(this,projwV);
        vArray[0] = v;
        vArray[1] = projwV;
        vArray[2] = secondVector;
        
        return vArray;
    }
    
    public static BTVector subtractVector(BTVector v1, BTVector v2)
    {
        double resultI;
        double resultJ;
        BTVector result;
        
        resultI = v1.getI()-v2.getI();
        resultJ = v1.getJ()-v2.getJ();
        result = new BTVector(resultI, resultJ);
        
        return result;
    }
    public BTVector getProjection(BTVector w)
    {
        BTVector projwV;
        double scalarVal = 0;
        
        //scalarVal = (getDotProduct(w)/(w.getMagnitude()*w.getMagnitude()));
        projwV = new BTVector(scalarVal*w.getI(),scalarVal*w.getJ());
        return projwV;
    }
    
    public double getWork(double Forcemag)
    {
        double result;
        
        result = Forcemag*getMagnitude()*Math.cos(getAngleRadianXAxes());
        
        return result;
    }
    public static double aCos(double x)
    {
        double x3 = x*x*x;
        double x5 = x3*x*x;
        double x7 = x5*x*x;
        
        return (Math.PI/2)-x-(x3/6)-((3*x5)/40)-((5*x7)/112);
    }
    public static double aTan(double x)
    {
        double index = (x+16)*32;
        int base = (int)index;
        if (base < 0)
            return -Math.PI/2;
        if (base >= atandata.length-1)
            return Math.PI/2;
        double z = index-base;
        return atandata[base]*z+atandata[base+1]*(1-z);
    }
}
