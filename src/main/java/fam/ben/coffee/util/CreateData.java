package fam.ben.coffee.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.cfg.NotYetImplementedException;

import fam.ben.coffee.model.Guest;
import fam.ben.coffee.model.Room;
import fam.ben.coffee.model.coffee.Pair;
import fam.ben.coffee.model.coffee.Person;
import fam.ben.coffee.repository.coffee.PairRepository;
import fam.ben.coffee.repository.coffee.PersonRepository;

public class CreateData {

    public static List<Person> createPersons(PersonRepository personRepository) {
        List<Person> persons = personRepository.findAll();

        if (persons.isEmpty()) {
            persons.add(new Person("Silvia", "Urlić"));
            persons.add(new Person("Antea", "Primorac"));
            persons.add(new Person("Maja", "Kordić"));
            persons.add(new Person("Angela", "Velček"));
            persons.add(new Person("Ana", "Mikić"));
            persons.add(new Person("Ana-Marija", "Baturina"));
            persons.add(new Person("Sunčica", "Hadaš"));
            persons.add(new Person("Kornelija", "Jurić"));
            persons.add(new Person("Stjepan", "Bencic"));
            persons.add(new Person("Josip", "Božić"));
            personRepository.saveAll(persons);
        }
        return persons;
    }

    public static Pair createPairFromNames(String first, String second, PersonRepository personRepository, LocalDate date) {
        String[] person1 = first.split(" ");
        String[] person2 = second.split(" ");

        Optional<Person> personFirst = personRepository.findByFirstNameAndLastName(person1[0], person1[1]).stream().findFirst();
        Optional<Person> personSecond = personRepository.findByFirstNameAndLastName(person2[0], person2[1]).stream().findFirst();

        if (personFirst.isPresent() && personSecond.isPresent()) {
            return new Pair(personFirst.get(), personSecond.get(), date);
        }

        return null;
    }

    /*

     Maja Kordić - Kornelija Jurić
     Sunčica Hadaš - Stjepan Bencic
     Angela Velček - Antea Primorac
     Ana-Marija Baturina - Ana Mikić
     Silvia Urlić - Josip Božić
    * */

    public static List<Pair> createPairsHadCoffee(PairRepository pairRepository, PersonRepository personRepository) {
        List<Person> persons = personRepository.findAll();
        List<Pair> pairs = pairRepository.findAll();
        if (pairs.isEmpty()) {
            pairs.add(createPairFromNames("Kornelija Jurić", "Sunčica Hadaš", personRepository, LocalDate.of(2021,10,21)));
            pairs.add(createPairFromNames("Ana-Marija Baturina", "Maja Kordić", personRepository, LocalDate.of(2021,10,21)));
            pairs.add(createPairFromNames("Silvia Urlić", "Angela Velček", personRepository, LocalDate.of(2021,10,21)));
            pairs.add(createPairFromNames("Antea Primorac", "Stjepan Bencic", personRepository, LocalDate.of(2021,10,21)));
            pairs.add(createPairFromNames("Ana Mikić", "Josip Božić", personRepository, LocalDate.of(2021,10,21)));
            pairs.add(createPairFromNames("Silvia Urlić", "Ana-Marija Baturina", personRepository, LocalDate.of(2021,11,10)));
            pairs.add(createPairFromNames("Maja Kordić", "Ana Mikić", personRepository, LocalDate.of(2021,11,10)));
            pairs.add(createPairFromNames("Angela Velček", "Kornelija Jurić", personRepository, LocalDate.of(2021,11,10)));
            pairs.add(createPairFromNames("Stjepan Bencic", "Josip Božić", personRepository, LocalDate.of(2021,11,10)));
            pairs.add(createPairFromNames("Antea Primorac", "Sunčica Hadaš", personRepository, LocalDate.of(2021,11,10)));
            pairs.add(createPairFromNames("Maja Kordić", "Kornelija Jurić", personRepository,LocalDate.of(2021,12,7)));
            pairs.add(createPairFromNames("Sunčica Hadaš", "Stjepan Bencic", personRepository,LocalDate.of(2021,12,7)));
            pairs.add(createPairFromNames("Angela Velček", "Antea Primorac", personRepository,LocalDate.of(2021,12,7)));
            pairs.add(createPairFromNames("Ana-Marija Baturina", "Ana Mikić", personRepository,LocalDate.of(2021,12,7)));
            pairs.add(createPairFromNames("Silvia Urlić", "Josip Božić", personRepository, LocalDate.of(2021,12,7)));

            pairRepository.saveAll(pairs);
        }

        return pairs;
    }

    public static List<Guest> createGuests() {
        List<Guest> guests = new ArrayList<>();
        guests.add(new Guest("Adams", "Roy", "radams1v@xinhuanet.com", "United States", "2872 Marquette Street", "NY", "1-(235)314-9823"));
        guests.add(new Guest("Adams", "Martin", "madams2b@msu.edu", "China", "4 Mandrake Plaza", "", "9-(401)660-9813"));
        guests.add(new Guest("Alvarez", "Roger", "ralvarezk@blogs.com", "United States", "3 Green Plaza", "FL", "6-(980)036-6105"));
        guests.add(new Guest("Alvarez", "Anne", "aalvarez1y@mlb.com", "United States", "6 Glendale Parkway", "FL", "7-(967)349-7237"));
        guests.add(new Guest("Alvarez", "Ann", "aalvarez20@jalbum.net", "Afghanistan", "851 Nelson Circle", "", "7-(418)731-2327"));
        guests.add(new Guest("Anderson", "Betty", "banderson14@digg.com", "United States", "3538 Scofield Drive", "TX", "1-(291)830-0405"));
        guests.add(new Guest("Anderson", "Laura", "landerson24@icio.us", "United States", "805 Paget Court", "NY", "3-(587)240-6409"));
        guests.add(
          new Guest("Armstrong", "Christopher", "carmstrong2p@cyberchimps.com", "United States", "4514 Independence Point", "TX", "3-(411)160-3757"));
        guests.add(new Guest("Bell", "David", "dbell2l@wp.com", "United States", "5205 Vera Junction", "CA", "8-(035)412-4547"));
        guests.add(new Guest("Berry", "Paula", "pberry1z@admin.ch", "China", "5095 International Drive", "", "6-(195)796-7745"));
        guests.add(new Guest("Bishop", "Dennis", "dbishopo@xinhuanet.com", "Armenia", "11442 East Circle", "", "4-(871)489-3543"));
        guests.add(new Guest("Bishop", "Carolyn", "cbishopw@1688.com", "Ukraine", "23273 Emmet Road", "", "5-(795)729-5690"));
        guests.add(new Guest("Black", "Harold", "hblack2p@clickbank.net", "Indonesia", "7715 Havey Center", "", "0-(378)142-3343"));
        guests.add(new Guest("Bowman", "Jerry", "jbowman1j@fotki.com", "Indonesia", "49381 Northridge Point", "", "9-(389)678-8585"));
        guests.add(new Guest("Bradley", "Keith", "kbradley1c@techcrunch.com", "United States", "21 Sauthoff Point", "OH", "5-(780)609-5353"));
        guests.add(new Guest("Brooks", "Samuel", "sbrooks4@google.co.uk", "United States", "9857 Hollow Ridge Park", "PA", "5-(517)250-0437"));
        guests.add(new Guest("Bryant", "Donald", "dbryant1@cdbaby.com", "South Korea", "8 Crescent Oaks Circle", "", "5-(629)251-0019"));
        guests.add(new Guest("Burke", "Tammy", "tburke2a@theglobeandmail.com", "Russia", "7298 Bluejay Road", "", "8-(710)063-1619"));
        guests.add(new Guest("Burns", "Joe", "jburns18@mail.ru", "Russia", "2795 Lighthouse Bay Place", "", "3-(465)132-7455"));
        guests.add(new Guest("Campbell", "Jessica", "jcampbell2i@cpanel.net", "United States", "7963 Ohio Alley", "OR", "0-(150)386-2177"));
        guests.add(new Guest("Campbell", "Christopher", "ccampbell2i@amazon.de", "Russia", "6 Walton Court", "", "5-(275)117-4811"));
        guests.add(new Guest("Carpenter", "Pamela", "pcarpenterj@china.com.cn", "United States", "661 Karstens Road", "HI", "6-(268)816-2465"));
        guests.add(new Guest("Carpenter", "Paul", "pcarpenter28@dropbox.com", "Philippines", "33614 Cambridge Road", "", "3-(561)990-7094"));
        guests.add(new Guest("Carter", "Tammy", "tcarter1j@washington.edu", "United States", "3 Leroy Crossing", "TN", "7-(489)865-7002"));
        guests.add(new Guest("Carter", "Paul", "pcarter1z@cnet.com", "United States", "3 Green Plaza", "CA", "3-(854)158-1783"));
        guests.add(new Guest("Chapman", "Justin", "jchapmans@aol.com", "United States", "2127 David Lane", "WV", "1-(910)152-0295"));
        guests.add(new Guest("Chapman", "Margaret", "mchapmanb@hud.gov", "Canada", "953 Reindahl Parkway", "", "1-(010)495-9996"));
        guests.add(new Guest("Clark", "Bonnie", "bclark6@bing.com", "United States", "4 Porter Avenue", "CO", "9-(524)812-6248"));
        guests.add(new Guest("Clark", "Andrea", "aclark2j@sphinn.com", "United States", "02 Haas Park", "MI", "1-(123)323-9494"));
        guests.add(new Guest("Coleman", "Shirley", "scoleman26@bizjournals.com", "United States", "4903 Commercial Drive", "AL", "7-(798)598-1459"));
        guests.add(new Guest("Coleman", "Angela", "acoleman6@gmpg.org", "Russia", "1208 Menomonie Terrace", "", "9-(959)063-5551"));
        guests.add(new Guest("Cox", "Harold", "hcox23@dyndns.org", "France", "08 Butterfield Place", "B5", "6-(983)957-3202"));
        guests.add(new Guest("Cruz", "Alan", "acruzj@marketwatch.com", "China", "023 Laurel Terrace", "", "1-(003)990-0308"));
        guests.add(new Guest("Cunningham", "Anna", "acunningham2@yale.edu", "China", "1 Steenband Lane", "", "7-(769)474-5961"));
        guests.add(new Guest("Daniels", "Robin", "rdaniels2d@weebly.com", "United States", "9728 Paget Court", "AR", "7-(116)447-5902"));
        guests.add(new Guest("Daniels", "Phillip", "pdaniels1y@hexun.com", "Kazakhstan", "5 Blue Bill Park Trail", "", "4-(029)713-9304"));
        guests.add(new Guest("Davis", "Thomas", "tdavis1h@globo.com", "United States", "6332 Fuller Pass", "TX", "5-(778)054-9695"));
        guests.add(new Guest("Dean", "Joe", "jdeanp@vinaora.com", "United States", "8 Darwin Crossing", "AZ", "9-(625)975-9705"));
        guests.add(new Guest("Dean", "Sara", "sdean1t@unc.edu", "Mexico", "9 South Crossing", "GUA", "7-(206)725-7117"));
        guests.add(new Guest("Dixon", "Patricia", "pdixon2m@biglobe.ne.jp", "United States", "49 Moose Way", "DC", "1-(159)384-4102"));
        guests.add(new Guest("Dixon", "Cynthia", "cdixon1e@vimeo.com", "China", "52645 Dorton Pass", "", "6-(422)372-7084"));
        guests.add(new Guest("Dixon", "Todd", "tdixon2o@ed.gov", "China", "82172 Lukken Alley", "", "0-(290)722-9657"));
        guests.add(new Guest("Elliott", "David", "delliottn@wsj.com", "Russia", "6478 Doe Crossing Court", "", "4-(687)980-5138"));
        guests.add(new Guest("Elliott", "Gregory", "gelliott2f@exblog.jp", "Indonesia", "01298 Raven Alley", "", "2-(826)961-5278"));
        guests.add(new Guest("Ellis", "James", "jellisa@wordpress.com", "United States", "8108 Upham Avenue", "CA", "9-(104)768-0365"));
        guests.add(new Guest("Ferguson", "Russell", "rferguson1b@uol.com.br", "United States", "9143 Hudson Terrace", "OH", "7-(498)208-8970"));
        guests.add(new Guest("Ferguson", "Mark", "mferguson2m@columbia.edu", "Poland", "6 Fisk Drive", "", "7-(920)445-0162"));
        guests.add(new Guest("Fields", "Lori", "lfieldsq@smh.com.au", "United States", "76485 Roth Alley", "WA", "2-(229)182-4243"));
        guests.add(new Guest("Fisher", "Thomas", "tfisher26@sina.com.cn", "Uzbekistan", "8 Haas Avenue", "", "1-(842)637-0935"));
        guests.add(new Guest("Ford", "Matthew", "mfordi@ucoz.com", "Syria", "63 East Place", "", "5-(508)161-9676"));
        guests.add(new Guest("Fowler", "Clarence", "cfowler1t@unicef.org", "United States", "890 Nevada Road", "CT", "5-(922)750-2234"));
        guests.add(new Guest("Fowler", "Steve", "sfowler2f@ed.gov", "United States", "243 Ohio Plaza", "AL", "8-(435)340-9290"));
        guests.add(new Guest("Fox", "Craig", "cfox1v@sakura.ne.jp", "Philippines", "576 Novick Alley", "", "3-(453)987-1524"));
        guests.add(new Guest("Freeman", "Kimberly", "kfreemank@cmu.edu", "Australia", "46613 Buena Vista Pass", "NSW", "0-(289)984-9766"));
        guests.add(new Guest("Freeman", "Johnny", "jfreeman1g@aboutads.info", "China", "719 Trailsway Street", "", "6-(658)139-7764"));
        guests.add(new Guest("Garza", "Carl", "cgarzal@friendfeed.com", "United States", "92 Scott Court", "DC", "2-(818)774-1651"));
        guests.add(new Guest("Garza", "Martha", "mgarza29@fastcompany.com", "Philippines", "64 Farwell Circle", "", "9-(455)359-2298"));
        guests.add(new Guest("George", "Angela", "ageorgew@bashdot.org", "United States", "1 Corben Street", "MD", "5-(864)699-8310"));
        guests.add(new Guest("George", "Linda", "lgeorge27@mtv.com", "United States", "5793 Northport Center", "MI", "7-(899)692-4554"));
        guests.add(new Guest("Gilbert", "Rose", "rgilbert1c@java.com", "Indonesia", "32441 Oriole Junction", "", "9-(771)659-3359"));
        guests.add(new Guest("Gomez", "Jacqueline", "jgomeze@miitbeian.gov.cn", "France", "794 Armistice Crossing", "A7", "9-(345)143-4371"));
        guests.add(new Guest("Gordon", "Antonio", "agordon28@weather.com", "United States", "8 Maywood Parkway", "CA", "5-(724)135-8826"));
        guests.add(new Guest("Grant", "Raymond", "rgrant11@amazonaws.com", "China", "248 Scott Trail", "", "0-(001)715-0415"));
        guests.add(new Guest("Grant", "Janet", "jgrant2c@nbcnews.com", "Philippines", "07 Schurz Circle", "", "3-(757)166-1573"));
        guests.add(new Guest("Gray", "Steven", "sgray17@over-blog.com", "Sweden", "4 5th Street", "AB", "8-(004)861-6730"));
        guests.add(new Guest("Hamilton", "William", "whamilton2a@biglobe.ne.jp", "United States", "23 Ronald Regan Drive", "MO", "7-(178)515-6650"));
        guests.add(new Guest("Hamilton", "Ernest", "ehamilton0@51.la", "Poland", "3 Bay Park", "", "1-(402)667-5979"));
        guests.add(new Guest("Hansen", "Jane", "jhansen0@xrea.com", "United States", "8 Beilfuss Place", "SC", "8-(468)743-8087"));
        guests.add(new Guest("Hansen", "Annie", "ahansen7@furl.net", "United States", "728 Fisk Plaza", "MD", "3-(527)508-7158"));
        guests.add(new Guest("Hanson", "Carolyn", "chanson1r@netlog.com", "United States", "5066 Dottie Junction", "NY", "8-(597)931-5162"));
        guests.add(new Guest("Hanson", "Christopher", "chansonp@ftc.gov", "Indonesia", "50 Claremont Crossing", "", "5-(759)595-6039"));
        guests.add(new Guest("Harris", "Michael", "mharris2g@printfriendly.com", "United States", "43 Veith Parkway", "CT", "2-(345)753-2214"));
        guests.add(new Guest("Harrison", "Stephanie", "sharrison21@devhub.com", "Poland", "709 Pepper Wood Avenue", "", "1-(280)302-4944"));
        guests.add(new Guest("Harvey", "Anne", "aharvey2g@sfgate.com", "China", "4 American Place", "", "9-(535)847-7555"));
        guests.add(new Guest("Hayes", "Barbara", "bhayes2q@jiathis.com", "United States", "6 Scofield Circle", "TX", "0-(173)195-7190"));
        guests.add(new Guest("Hayes", "Nicole", "nhayes10@qq.com", "China", "98830 Schlimgen Park", "", "7-(755)477-0983"));
        guests.add(new Guest("Hayes", "Emily", "ehayes1h@ox.ac.uk", "Indonesia", "784 Susan Street", "", "8-(944)943-0482"));
        guests.add(new Guest("Henderson", "Martin", "mhenderson16@wsj.com", "United States", "7306 Buhler Plaza", "TX", "6-(058)886-9240"));
        guests.add(new Guest("Hernandez", "Billy", "bhernandezx@sphinn.com", "United States", "994 Kennedy Street", "PA", "2-(728)757-6883"));
        guests.add(new Guest("Hernandez", "Heather", "hhernandezr@hostgator.com", "Indonesia", "74 Clove Drive", "", "5-(593)151-3362"));
        guests.add(new Guest("Hicks", "Sharon", "shicks3@wsj.com", "Indonesia", "0974 Calypso Junction", "", "3-(868)311-6209"));
        guests.add(new Guest("Hicks", "Lori", "lhicks9@wordpress.org", "China", "854 Lakewood Gardens Court", "", "9-(849)992-9828"));
        guests.add(new Guest("Howard", "Richard", "rhoward1i@theatlantic.com", "United States", "6 Welch Pass", "CA", "5-(673)015-8549"));
        guests.add(new Guest("Howell", "Ronald", "rhowell13@soup.io", "Japan", "75904 Hoffman Way", "", "3-(124)276-4530"));
        guests.add(new Guest("Hughes", "Judy", "jhughes25@4shared.com", "United States", "03 Sullivan Circle", "DE", "4-(702)002-3923"));
        guests.add(new Guest("Hunter", "Amy", "ahuntere@intel.com", "United States", "9781 Kennedy Avenue", "WV", "0-(992)102-4834"));
        guests.add(new Guest("Jackson", "Kathryn", "kjackson3@wikia.com", "United States", "43603 Northwestern Plaza", "MS", "9-(266)577-1031"));
        guests.add(new Guest("Jenkins", "Steven", "sjenkins1e@a8.net", "United States", "7396 Canary Center", "CA", "3-(613)563-6513"));
        guests.add(new Guest("Johnson", "Kevin", "kjohnson2h@unesco.org", "Poland", "5 Haas Circle", "", "8-(553)359-6387"));
        guests.add(new Guest("Johnston", "Christina", "cjohnston1m@nationalgeographic.com", "Gabon", "05059 Fordem Lane", "", "7-(543)809-5071"));
        guests.add(new Guest("Johnston", "Ryan", "rjohnston1s@ucla.edu", "Russia", "4 Sunfield Avenue", "", "3-(807)624-4323"));
        guests.add(new Guest("Jordan", "Marie", "mjordan1n@weather.com", "United States", "5 Moulton Avenue", "GA", "9-(380)848-6527"));
        guests.add(new Guest("Kelley", "Pamela", "pkelley2c@hibu.com", "United States", "97636 5th Pass", "KS", "0-(546)670-0937"));
        guests.add(new Guest("Kelly", "Evelyn", "ekelly2h@facebook.com", "United States", "82091 Leroy Center", "KY", "5-(319)309-1959"));
        guests.add(new Guest("Kennedy", "Dorothy", "dkennedy23@unblog.fr", "United States", "01 Park Meadow Place", "TX", "0-(605)308-6131"));
        guests.add(new Guest("King", "Sean", "skingl@geocities.jp", "Indonesia", "6611 Spaight Street", "", "5-(463)415-7449"));
        guests.add(new Guest("King", "Kimberly", "kking1r@naver.com", "Nigeria", "7 Northfield Avenue", "", "4-(192)264-2329"));
        guests.add(new Guest("King", "Nicholas", "nking2r@businessweek.com", "Philippines", "3 Gulseth Drive", "", "4-(647)544-4105"));
        guests.add(new Guest("Knight", "Katherine", "kknight1p@walmart.com", "United States", "3 Surrey Circle", "LA", "6-(906)910-4569"));
        guests.add(new Guest("Larson", "Martin", "mlarson24@tripadvisor.com", "United States", "32 Surrey Road", "NC", "8-(568)965-0021"));
        guests.add(new Guest("Lee", "Louis", "lleeh@yellowbook.com", "United States", "80 Boyd Court", "NJ", "3-(100)131-3147"));
        guests.add(new Guest("Lewis", "Ruby", "rlewisv@answers.com", "United States", "37 Saint Paul Place", "IA", "1-(585)331-1972"));
        guests.add(new Guest("Lewis", "Jonathan", "jlewis4@tuttocitta.it", "Mauritania", "1771 Cascade Place", "", "2-(107)787-5478"));
        guests.add(new Guest("Little", "Eric", "elittle18@cdc.gov", "United States", "1008 6th Street", "FL", "9-(855)524-1969"));
        guests.add(new Guest("Little", "Kathy", "klittlec@bideshare.net", "China", "033 Victoria Circle", "", "9-(104)402-8499"));
        guests.add(new Guest("Martin", "Frank", "fmartin1a@ed.gov", "United States", "21822 Talisman Drive", "TX", "1-(296)887-1815"));
        guests.add(new Guest("Martin", "Roy", "rmarting@delicious.com", "Bolivia", "789 Scoville Plaza", "", "8-(330)043-5619"));
        guests.add(new Guest("Martinez", "Randy", "rmartinez1q@adobe.com", "United States", "9031 Clove Court", "KS", "6-(835)245-0202"));
        guests.add(new Guest("Mason", "Janet", "jmason1m@pbs.org", "United States", "48485 Springs Lane", "WA", "0-(404)244-1973"));
        guests.add(new Guest("Mcdonald", "Ann", "amcdonaldu@drupal.org", "United States", "94 Columbus Crossing", "IN", "2-(019)467-7792"));
        guests.add(new Guest("Mcdonald", "Kathryn", "kmcdonald5@mit.edu", "Indonesia", "3486 Vidon Street", "", "3-(381)326-4723"));
        guests.add(new Guest("Meyer", "Lisa", "lmeyer2k@ycombinator.com", "Tuvalu", "6 Mallory Circle", "", "6-(321)779-8895"));
        guests.add(new Guest("Miller", "Pamela", "pmiller2b@t-online.de", "United States", "951 High Crossing Alley", "TX", "1-(377)914-2151"));
        guests.add(new Guest("Miller", "Brandon", "bmiller1u@prweb.com", "Indonesia", "3992 Sugar Circle", "", "6-(106)294-1370"));
        guests.add(new Guest("Miller", "Julia", "jmiller2d@zdnet.com", "Argentina", "551 Bartelt Crossing", "", "0-(666)185-0852"));
        guests.add(new Guest("Montgomery", "Lois", "lmontgomeryf@nba.com", "United States", "8 Farwell Center", "NC", "8-(375)554-1933"));
        guests.add(new Guest("Morales", "Jonathan", "jmorales19@ed.gov", "United States", "715 Muir Pass", "TX", "7-(721)881-1745"));
        guests.add(new Guest("Moreno", "Ronald", "rmorenoa@wp.com", "Indonesia", "6832 Dakota Drive", "", "1-(452)732-4207"));
        guests.add(new Guest("Moreno", "Anne", "amorenox@imgur.com", "China", "72 Autumn Leaf Drive", "", "7-(297)043-6194"));
        guests.add(new Guest("Moreno", "Martha", "mmoreno1a@skyrock.com", "China", "41 Ridgeview Pass", "", "8-(179)386-6387"));
        guests.add(new Guest("Moreno", "Linda", "lmoreno22@odnoklassniki.ru", "Indonesia", "09 Mesta Street", "", "6-(716)643-5063"));
        guests.add(new Guest("Morgan", "Shawn", "smorgany@a8.net", "United States", "5351 Blaine Street", "UT", "9-(614)327-3110"));
        guests.add(new Guest("Morgan", "Ruby", "rmorgan1n@narod.ru", "France", "13 Arapahoe Drive", "B2", "4-(056)808-7190"));
        guests.add(new Guest("Morris", "Russell", "rmorrist@yahoo.com", "United States", "2 Dryden Street", "CA", "8-(312)542-5335"));
        guests.add(new Guest("Morris", "Ernest", "emorris17@linkedin.com", "United States", "538 Lawn Hill", "NY", "0-(722)159-2263"));
        guests.add(new Guest("Morris", "Frank", "fmorris15@goo.ne.jp", "Greece", "073 Moland Avenue", "", "3-(574)360-9298"));
        guests.add(new Guest("Murphy", "Sharon", "smurphy1x@exblog.jp", "United States", "030 Tomscot Trail", "NC", "3-(392)774-3776"));
        guests.add(new Guest("Murray", "Angela", "amurray1f@elegantthemes.com", "United States", "11496 Bobwhite Junction", "VA", "7-(311)742-6306"));
        guests.add(new Guest("Murray", "Tina", "tmurray8@admin.ch", "Brazil", "63 Arapahoe Avenue", "", "7-(922)695-1373"));
        guests.add(new Guest("Murray", "Judith", "jmurray12@weather.com", "China", "772 Eagle Crest Court", "", "5-(447)261-8375"));
        guests.add(new Guest("Nguyen", "Michelle", "mnguyen9@home.pl", "United States", "76 Vidon Crossing", "LA", "3-(168)110-6625"));
        guests.add(new Guest("Nichols", "Sean", "snichols1d@alexa.com", "Indonesia", "48 Garrison Court", "", "9-(909)775-6033"));
        guests.add(new Guest("Owens", "Joyce", "jowens1o@icq.com", "United States", "0017 Fordem Hill", "CA", "6-(213)022-2309"));
        guests.add(new Guest("Owens", "Alan", "aowens16@domainmarket.com", "Zimbabwe", "9 Tomscot Place", "", "3-(534)603-4932"));
        guests.add(new Guest("Perez", "Rebecca", "rperezo@sbwire.com", "United States", "67390 Manitowish Pass", "TX", "7-(406)875-9890"));
        guests.add(new Guest("Perez", "Marilyn", "mperez1g@epa.gov", "United States", "191 East Lane", "TN", "2-(678)829-2820"));
        guests.add(new Guest("Perry", "John", "jperry1d@xinhuanet.com", "United States", "02184 2nd Way", "MD", "3-(362)867-6688"));
        guests.add(new Guest("Perry", "Sharon", "sperryd@barnesandnoble.com", "China", "9202 Clemons Avenue", "", "3-(895)126-1278"));
        guests.add(new Guest("Pierce", "Alice", "apierce2r@umich.edu", "United States", "6 Corben Trail", "MI", "0-(467)177-3734"));
        guests.add(new Guest("Pierce", "Ernest", "epierce1w@flavors.me", "France", "99 Warner Drive", "B2", "7-(918)938-0007"));
        guests.add(new Guest("Pierce", "Lois", "lpierce2n@spotify.com", "Argentina", "819 Holy Cross Drive", "", "4-(370)593-0211"));
        guests.add(new Guest("Porter", "Debra", "dporter1x@sakura.ne.jp", "Indonesia", "1 Haas Street", "", "8-(747)340-6398"));
        guests.add(new Guest("Ramirez", "Frank", "framirez2k@goodreads.com", "United States", "3 Rowland Parkway", "NC", "0-(669)037-4790"));
        guests.add(new Guest("Ray", "Norma", "nray1l@columbia.edu", "United States", "8 Crescent Oaks Terrace", "CA", "3-(007)729-3299"));
        guests.add(new Guest("Reid", "Katherine", "kreid2@reverbnation.com", "United States", "51 Stang Crossing", "CA", "1-(816)180-4329"));
        guests.add(new Guest("Reid", "Phyllis", "preids@amazon.co.uk", "Peru", "46 Rusk Parkway", "", "8-(695)108-5308"));
        guests.add(new Guest("Reid", "Ashley", "areid1p@taobao.com", "United States", "88 Village Green Center", "OH", "0-(960)491-5644"));
        guests.add(new Guest("Reyes", "Nicole", "nreyes5@exblog.jp", "United States", "67524 Nobel Way", "AZ", "7-(420)898-9688"));
        guests.add(new Guest("Reynolds", "Gary", "greynoldsz@state.gov", "United States", "1 Prairieview Center", "WA", "5-(337)284-9527"));
        guests.add(new Guest("Richards", "Jessica", "jrichards21@issuu.com", "United States", "924 John Wall Trail", "ME", "8-(061)711-6311"));
        guests.add(new Guest("Riley", "Patricia", "prileyd@topsy.com", "United States", "459 3rd Avenue", "GA", "8-(662)260-9720"));
        guests.add(
          new Guest("Rivera", "Cynthia", "crivera1i@dagondesign.com", "Central African Republic", "257 Raven Street", "", "2-(285)744-2177"));
        guests.add(new Guest("Rodriguez", "Christine", "crodriguez1l@amazonaws.com", "Mauritius", "78026 Everett Center", "", "8-(868)081-1984"));
        guests.add(new Guest("Rodriguez", "Kelly", "krodriguez25@china.com.cn", "Dominican Republic", "9 Beilfuss Plaza", "", "7-(441)055-8273"));
        guests.add(new Guest("Rogers", "Frank", "frogers1w@statcounter.com", "United States", "37717 Rutledge Park", "PA", "8-(685)173-5668"));
        guests.add(new Guest("Rogers", "Janet", "jrogers1o@ft.com", "Argentina", "5 Muir Terrace", "", "5-(740)110-8659"));
        guests.add(new Guest("Rose", "Sarah", "srose1@japanpost.jp", "United States", "3147 3rd Place", "CA", "9-(625)374-4080"));
        guests.add(new Guest("Rose", "Scott", "srose2o@chron.com", "United States", "7741 Dennis Crossing", "IA", "2-(957)474-8286"));
        guests.add(new Guest("Ruiz", "Paula", "pruiz10@de.vu", "United States", "0 Stone Corner Drive", "CA", "5-(733)929-8978"));
        guests.add(new Guest("Russell", "Jerry", "jrussellh@mtv.com", "Indonesia", "18 Redwing Center", "", "7-(835)874-3804"));
        guests.add(new Guest("Ryan", "Patrick", "pryanq@bing.com", "Portugal", "2456 Randy Junction", "13", "7-(908)548-4462"));
        guests.add(new Guest("Sanchez", "Shawn", "ssanchezy@utexas.edu", "Colombia", "3 Butternut Point", "", "6-(314)041-2239"));
        guests.add(new Guest("Sanders", "Patricia", "psandersb@squarespace.com", "United States", "9349 Morning Center", "MO", "1-(201)273-2884"));
        guests.add(new Guest("Sanders", "Marie", "msandersz@jiathis.com", "Indonesia", "956 Texas Terrace", "", "6-(897)485-7971"));
        guests.add(new Guest("Sanders", "Frances", "fsanders2j@ow.ly", "China", "048 Mifflin Plaza", "", "5-(360)904-8808"));
        guests.add(new Guest("Shaw", "Carol", "cshaw2e@marriott.com", "United States", "650 Grover Alley", "GA", "6-(867)939-2196"));
        guests.add(new Guest("Simmons", "James", "jsimmons22@mysql.com", "United States", "79 Hansons Circle", "VA", "4-(084)741-2810"));
        guests.add(new Guest("Snyder", "Fred", "fsnyder2n@samsung.com", "United States", "5 8th Drive", "CA", "4-(204)127-6115"));
        guests.add(new Guest("Snyder", "Benjamin", "bsnyderv@cafepress.com", "Poland", "8 Steenband Point", "", "3-(961)447-1196"));
        guests.add(new Guest("Stephens", "Joyce", "jstephens20@zimbio.com", "United States", "5 Toban Drive", "MO", "9-(961)593-9442"));
        guests.add(new Guest("Stephens", "Barbara", "bstephens1f@yellowbook.com", "Cuba", "27 Fulton Plaza", "", "5-(765)751-8667"));
        guests.add(new Guest("Stone", "Kelly", "kstonei@cdc.gov", "United States", "26 Kropf Way", "NY", "8-(139)634-6415"));
        guests.add(new Guest("Torres", "Angela", "atorres8@uol.com.br", "United States", "63232 Columbus Place", "MA", "1-(439)654-3373"));
        guests.add(new Guest("Tucker", "Roy", "rtuckerg@example.com", "United States", "6707 Maple Parkway", "OH", "3-(093)128-8690"));
        guests.add(new Guest("Tucker", "Joseph", "jtucker15@disqus.com", "United States", "17922 Quincy Pass", "CA", "0-(990)513-0451"));
        guests.add(new Guest("Tucker", "Dorothy", "dtucker14@ehow.com", "France", "3593 Atwood Circle", "B5", "9-(243)144-3879"));
        guests.add(new Guest("Turner", "Rebecca", "rturner27@google.co.uk", "China", "89156 Atwood Junction", "", "4-(853)728-1963"));
        guests.add(new Guest("Wagner", "Brian", "bwagner13@quantcast.com", "United States", "3833 Pierstorff Point", "MD", "5-(595)231-2208"));
        guests.add(new Guest("Walker", "Kenneth", "kwalker29@aboutads.info", "United States", "9 Superior Crossing", "WA", "0-(953)489-2738"));
        guests.add(new Guest("Wallace", "Debra", "dwallacer@nps.gov", "United States", "23 Ohio Terrace", "CT", "0-(483)351-8933"));
        guests.add(new Guest("Ward", "Raymond", "rwardm@nationalgeographic.com", "United States", "47656 Old Shore Street", "NC", "3-(715)261-7860"));
        guests.add(new Guest("Warren", "Henry", "hwarren19@apache.org", "Philippines", "12 Kennedy Plaza", "", "4-(180)111-6593"));
        guests.add(new Guest("Washington", "Henry", "hwashington2q@mail.ru", "Indonesia", "80 Autumn Leaf Street", "", "6-(962)303-1876"));
        guests.add(new Guest("Watkins", "Adam", "awatkinst@timesonline.co.uk", "Egypt", "4 Susan Street", "", "7-(977)440-3683"));
        guests.add(new Guest("Watkins", "Nicholas", "nwatkins1b@va.gov", "China", "74962 Steenband Avenue", "", "1-(946)323-6647"));
        guests.add(new Guest("Watson", "Timothy", "twatson1k@shinystat.com", "United States", "184 Lukken Hill", "NE", "1-(046)935-7571"));
        guests.add(new Guest("Webb", "Louis", "lwebb2e@blogspot.com", "Indonesia", "1958 Granby Avenue", "", "0-(713)613-4968"));
        guests.add(new Guest("Webb", "Charles", "cwebb2l@twitter.com", "Latvia", "5012 Eggendart Pass", "", "2-(444)641-6850"));
        guests.add(new Guest("Welch", "Tina", "twelch1u@yahoo.co.jp", "United States", "4 Bashford Terrace", "MN", "1-(518)288-4237"));
        guests.add(new Guest("Welch", "Rose", "rwelchu@gnu.org", "Serbia", "56176 Burning Wood Lane", "", "9-(271)628-1625"));
        guests.add(new Guest("Wheeler", "Paula", "pwheeler1s@mac.com", "United States", "39639 Leroy Avenue", "OH", "4-(874)769-0414"));
        guests.add(new Guest("Williams", "Shawn", "swilliamsc@joomla.org", "United States", "60 Sugar Plaza", "MI", "4-(867)695-7864"));
        guests.add(new Guest("Williams", "Harold", "hwilliamsm@dion.ne.jp", "Russia", "6728 Colorado Street", "", "5-(250)547-3562"));
        guests.add(new Guest("Willis", "Paul", "pwillis12@e-recht24.de", "United States", "0177 Everett Junction", "DC", "7-(560)524-0255"));
        guests.add(new Guest("Wood", "Jose", "jwoodn@mtv.com", "United States", "59447 Ludington Parkway", "NY", "3-(322)044-6672"));
        guests.add(new Guest("Wood", "Janet", "jwood1k@goodreads.com", "Ireland", "445 Harper Parkway", "", "0-(943)656-4847"));
        guests.add(new Guest("Wright", "Victor", "vwright7@baidu.com", "Ukraine", "542 Mandrake Center", "", "0-(279)357-3386"));
        guests.add(new Guest("Wright", "Kimberly", "kwrightf@tinyurl.com", "Brazil", "9893 Summit Plaza", "", "3-(288)433-6668"));
        guests.add(new Guest("Wright", "Joan", "jwright1q@phoca.cz", "Moldova", "55 Dawn Parkway", "", "7-(830)749-3794"));
        guests.add(new Guest("Young", "Judith", "jyoung11@goodreads.com", "United States", "2 Sachtjen Parkway", "WV", "9-(659)879-6466"));

        return guests;

    }

    public static List<Room> createRooms() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Piccadilly", "P1", "1Q"));
        rooms.add(new Room("Piccadilly", "P2", "1Q"));
        rooms.add(new Room("Piccadilly", "P3", "1Q"));
        rooms.add(new Room("Piccadilly", "P4", "2D"));
        rooms.add(new Room("Piccadilly", "P5", "2D"));
        rooms.add(new Room("Piccadilly", "P6", "2D"));
        rooms.add(new Room("Cambridge", "C1", "1K"));
        rooms.add(new Room("Cambridge", "C2", "1K"));
        rooms.add(new Room("Cambridge", "C3", "1K"));
        rooms.add(new Room("Westminster", "W1", "1K"));
        rooms.add(new Room("Westminster", "W2", "1K"));
        rooms.add(new Room("Westminster", "W3", "1K"));
        rooms.add(new Room("Westminster", "W4", "1K"));
        rooms.add(new Room("Westminster", "W5", "2D"));
        rooms.add(new Room("Westminster", "W6", "2D"));
        rooms.add(new Room("Westminster", "W7", "2D"));
        rooms.add(new Room("Oxford", "O1", "1K"));
        rooms.add(new Room("Oxford", "O2", "1K"));
        rooms.add(new Room("Oxford", "O3", "1Q"));
        rooms.add(new Room("Oxford", "O4", "1Q"));
        rooms.add(new Room("Oxford", "O5", "1Q"));
        rooms.add(new Room("Victoria", "V1", "1K"));
        rooms.add(new Room("Victoria", "V2", "2D"));
        rooms.add(new Room("Victoria", "V3", "2D"));
        rooms.add(new Room("Manchester", "M1", "1K"));
        rooms.add(new Room("Manchester", "M2", "1K"));
        rooms.add(new Room("Manchester", "M3", "1K"));
        rooms.add(new Room("Manchester", "M4", "1K"));

        return rooms;
    }

}
