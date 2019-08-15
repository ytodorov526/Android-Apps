package com.zoo20

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {


    var listOfAnimals = ArrayList<Animal>()

    var adapter: AnimalAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load animals
        listOfAnimals.add(Animal("Baboon", "Baboons are Old World monkeys", R.drawable.baboon,"There are five different species of baboons. All of them live in Africa or Arabia. Baboons are some of the world's largest monkeys, and males of different species average from 33 to 82 pounds. Baboon bodies are 20 to 40 inches long, not including substantial tails of varying lengths.\n" +
                "\n" +
                "Baboons generally prefer savanna and other semi-arid habitats, though a few live in tropical forests.\n" +
                "\n" +
                "Like other Old World monkeys, baboons do not have prehensile (gripping) tails. But they can and do climb trees to sleep, eat, or look out for trouble. They spend much of their time on the ground.\n" +
                "\n" +
                "Diet\n" +
                "\n" +
                "Baboons are opportunistic eaters and, fond of crops, become destructive pests to many African farmers. They eat fruits, grasses, seeds, bark, and roots, but also have a taste for meat. They eat birds, rodents, and even the young of larger mammals, such as antelopes and sheep.\n" +
                "\n" +
                "Population\n" +
                "\n" +
                "Four baboon species (i.e., chacma, olive, yellow, and Guinea) are known as the savanna baboons. These animals form large troops, composed of dozens or even hundreds of baboons, governed by a complex hierarchy that fascinates scientists. Males use shows of physical power to dominate rivals, and troop members spend endless hours carefully grooming one another to remove insects and dead skin.\n" +
                "\n" +
                "A fifth species, the hamadryas baboon, lives in the hills along the Red Sea coasts of Africa and Arabia. These cliff-dwelling baboons disperse to forage during the day and reconvene in much smaller groups at night."))
        listOfAnimals.add(Animal("Bulldog", "Bulldogs are lazy dogs", R.drawable.bulldog,"The English bulldog is a brawny little powerhouse whose characteristic crablike waddle exudes great strength, stability and vigor.\n" +
                "\n" +
                "The dog's head is large and spherical, and the muzzle is extremely short, giving the face a flattened appearance. The English bulldog's eyes are dark and set low and wide on the forehead in the frontal plane. The nose is black and slightly upturned. The jaws (or \"chops\") are massive, broad and undershot. The lower jaw juts out in front of the upper jaw to scarcely expose the lower incisors, producing a comical grin. The lips are fleshy and pendulous. The cheeks are well rounded and protrude sideways. The ears are thin, small and angle forward like flaps that frame the forehead.\n" +
                "\n" +
                "The English bulldog's neck is short and thick; the shoulders are massive, muscular and broad. The chest is deep and full, and the back is barreled and slightly arched. His rounded hips protrude slightly above the level of the back. The stubby tail is thick and either straight or screwed. His short, stocky legs have great muscle definition. They are splayed out and slightly bowed at the elbows and hocks to form a sturdy, base-wide stance.\n" +
                "\n" +
                "The English bulldog stands about 16 inches tall. The female weighs about 50 pounds (23 kilograms), and the male weighs about 54 pounds (24 kilograms).\n" +
                "\n" +
                "The English bulldog's skin is loose and pendant with heavy wrinkles and thick folds on the face and a dewlap hanging from the throat. The coat is short and fine textured. The various color patterns are brindle, piebald, and solid white, red, fawn or fallow.\n" +
                "\n" +
                "Personality:\n" +
                "The English bulldog has a sweet, gentle disposition. Dependable and predictable, the bulldog is a wonderful family pet and loving to most children. People-oriented as a breed, they actively solicit human attention.\n" +
                "\n" +
                "However, they have retained the courage that was originally bred into them for bull baiting, so they make fine watchdogs. Although they generally get along well with other family pets, English bulldogs can be aggressive to unfamiliar dogs.\n" +
                "\n" +
                "Living With:\n" +
                "English bulldogs make fine apartment pets and do not require a yard. Typically low-endurance dogs, they need only a moderate amount of exercise. They thrive best in temperate climates; they readily overheat and have breathing difficulties in hot weather, and they chill easily in cold temperatures.\n" +
                "\n" +
                "Generally loud breathers, English bulldogs tend to snore and wheeze. Many drool as well. They are moderate shedders and their short coats require little grooming. However, the wrinkles on the face should be wiped regularly to prevent skin infections.\n" +
                "\n" +
                "History:\n" +
                "Named for its use in the sport of bull baiting, the English bulldog seems to have originated in the British Isles sometime prior to the 13th century. One of the few references to the sport dates back to 1209, and talks about a butcher's dogs that chased a bull through the English town of Stamford. This pursuit so pleased the earl of the town that he inaugurated bull baiting as a sport in his domain.\n" +
                "\n" +
                "Today, the English bulldog makes a fine family pet. The AKC recognizes the breed simply as the bulldog."))
        listOfAnimals.add(Animal("Panda", "Pandas are known to eat bamboo", R.drawable.panda,"Pandas eat almost nothing but bamboo shoots and leaves. Occasionally they eat other vegetation, fish, or small animals, but bamboo accounts for 99 percent of their diets. Pandas eat fast, they eat a lot, and they spend about 12 hours a day doing it. The reason: They digest only about a fifth of what they eat. Overall, bamboo is not very nutritious. To stay healthy, they have to eat a lot—up to 15 percent of their body weight in 12 hours—so they eat fast.\n" +
                "\n" +
                "Pandas' molars are very broad and flat. The shape of the teeth helps the animals crush the bamboo shoots, leaves, and stems that they eat. They can chomp on bamboo up to one-and-a-half inches thick. To get the bamboo to their mouths, they hold the stems with their front paws, which have enlarged wrist bones that act as thumbs for gripping. A panda should have at least two bamboo species where it lives, or it will starve.  A scarcity in bamboo threatens the already limited panda population.\n" +
                "\n" +
                "An adult female panda weighs 200 pounds. Pandas can climb as high as 13,000 feet and are also very good swimmers. Sometimes male pandas relax by doing handstands against trees."))
        listOfAnimals.add(
            Animal(
                "Swallow bird",
                "Swallow birds are passerine birds and are highly adepted to feeding in the air",
                R.drawable.swallow_bird,"Swallow, any of the approximately 90 species of the bird family Hirundinidae (order Passeriformes). A few, including the bank swallow, are called martins (see martin; see also woodswallow; for sea swallow, see tern). Swallows are small, with pointed narrow wings, short bills, and small weak feet; some species have forked tails. Plumage may be plain or marked with metallic blue or green; the sexes look alike in most species.\n" +
                        "\n" +
                        "Swallows spend much time in the air, capturing insects; they are among the most agile of passerine birds. For nesting, swallows may use a hole or cranny in a tree, burrow into a sandbank, or plaster mud onto a wall or ledge to house three to seven white, sometimes speckled, eggs.\n" +
                        "\n" +
                        "Swallows occur worldwide except in the coldest regions and remotest islands. Temperate-zone species include long-distance migrants. The common swallow (Hirundo rustica) is almost worldwide in migration; an American species, called barn swallow, may summer in Canada and winter in Argentina. The 10 species of Petrochelidon, which make flask-shaped mud nests, include the cliff swallow (P. pyrrhonota), the bird of San Juan Capistrano Mission, in California; as with other swallows, it has strong homing instincts."
            )
        )
        listOfAnimals.add(
            Animal(
                "White tiger",
                "The white fur is caused by a lack of the pigment pheomelanin, which is found in Bengal tigers with orange color fur. ",
                R.drawable.white_tiger,"The ONLY way to produce a tiger or lion with a white coat is through inbreeding brother to sister or father to daughter; generation after generation after generation.  The kind of severe inbreeding that is required to produce the mutation of a white coat also causes a number of other defects in these big cats.\n" +
                        "\n" +
                        "In June 2011 the board of directors for the American Zoological Association (AZA) formalized their 2008 ban on the breeding of white tigers, white lions or king cheetahs by their member zoos.  Their report said, “Breeding practices that increase the physical expression of single rare alleles (i.e., rare genetic traits) through intentional inbreeding, for example intentional breeding to achieve rare color-morphs such as white tigers, deer, and alligators, has been clearly linked with various abnormal, debilitating, and, at times, lethal, external and internal conditions and characteristics, which are outlined in this paper.”   This change in policy came more than 12 years after Big Cat Rescue first released Dr. Laughlin’s expose below.\n" +
                        "\n" +
                        "The same gene that causes the white coat causes the optic nerve to be wired to the wrong side of the brain, thus all white tigers are cross eyed, even if their eyes look normal.  They also often suffer from club feet, cleft palates, spinal deformities and defective organs.\n" +
                        "\n" +
                        "The white coat is a double recessive gene so most of the cubs born through this inbreeding have normal coloring but they too suffer the same defects and are referred to in the trade as “throw away tigers.”  As such, they are often killed at birth because only the white tigers are the big money makers.  And because none of these cats are purebred (they are all crosses between Bengal tigers and Siberian tigers), they serve no conservation purpose.\n" +
                        "\n" +
                        "The American Zoological Association (AZA) recognizes that these cats should not be bred and admonishes AZA accredited zoos not to breed any more of them.  The leader of the tiger Species Survival Plan states openly that the only reason people breed white tigers is because people will pay to see white tigers."
            )
        )
        listOfAnimals.add(Animal("Zebra", "Zebras are several species of African equids", R.drawable.zebra,"Despite their appearance, zebras aren’t just black and white. They are sturdy, spirited animals that are a study in contrasts: willful and playful, social and standoffish, resilient and vulnerable. Their life in a herd can be complex, yet they also find safety in numbers. They are prey for predators, but they are by no means shrinking violets when it comes to defending themselves. Read between the lines, and you’ll discover that the world of the zebra is colorful indeed!\n" +
                "\n" +
                "Zebras are equids, members of the horse family. They have excellent hearing and eyesight and can run at speeds of up to 35 miles per hour (56 kilometers per hour). They also have a powerful kick that can cause serious injury to a predator, like a lion, a hyena, or an African wild dog. Usually the lead male of the herd, called a stallion, sounds the alarm if danger is spotted and stays at the back of the group to defend against predators if necessary, while the mares (females) and foals (youngsters) run away.\n" +
                "\n" +
                "Zebras often trot when moving to new pastures, which is a fairly fast but easy gait for them to use over the long distances they may have to travel. Their hard hooves are designed to withstand the impact of their body weight and to run easily over rocky ground. When resting at night, zebras lie down while one stands watch to prevent an ambush.\n" +
                "\n" +
                "Stripes: White with black or black with white? This is one of the most-asked questions about zebras. So what's up with the stripes? Zebras are generally thought to have white coats with black (sometimes brown) stripes. That's because if you look at most zebras, the stripes end on their belly and toward the inside of the legs, and the rest is all white. However (there had to be a catch, right?), some zebras are born with genetic variations that make them all black with white stripes, or mostly dark with the striped pattern on just part of their coats. And as it turns out, zebras have black skin underneath their hair. So it depends on how you look at it!\n" +
                "\n" +
                "So, why the stripes? They serve as a kind of protection from predators! When zebras are grouped together, their combined stripes make it hard for a lion or leopard to pick out one zebra to chase. Zebra stripes are unique to each individual, and researchers in the field have used zebras’ individual stripe patterns for identification.\n" +
                "\n" +
                "It might seem like a zebra is a zebra, but there are three different species: plains, mountain, and Grevy’s zebras. Different zebra species have different types of stripes, from narrow to wide. In fact, the farther south on the African plains you travel, the farther apart the stripes on the zebras get! The basic form of zebras—a large head, sturdy neck, long legs, a dorsal stripe along the spine and down a tasseled tail, and bristly mane—is universal. No zebra, or other wild equid, has a forelock.\n" +
                "\n" +
                "The Grevy’s zebra is the largest, weighing from 770 to 990 pounds (350 to 450 kilograms) and measuring up to 5 feet (1.5 meters) at the shoulder. Its thick neck and large, round ears give the Grevy’s zebra the most mule-like physique. The Grevy’s zebra also has the thinnest stripes, extending all the way down to their white belly; on the hindquarters the stripes are vertical until above the hind legs.\n" +
                "\n" +
                "A mountain zebra has vertical stripes on the neck and torso, which graduate to wider—and fewer—horizontal bars on the haunches. It has a gridiron pattern on the rump, and its white underside has a dark stripe that runs the length of the belly. A mountain zebra also has a distinctive dewlap on the throat that looks a bit like an Adam’s apple.\n" +
                "\n" +
                "The plains zebra is the most abundant and the smallest of the three zebra species. Some subspecies have a stripe pattern different from all others: brownish “shadow” stripes between the black stripes on their coat.\n" +
                "\n" +
                "HABITAT AND DIET\n" +
                "Different zebras have different habitats: Grevy’s zebras live in semi-arid grassland habitat in Kenya, Ethiopia, and Somalia. Mountain zebras, as their name implies, inhabit rocky, arid slopes in Namibia and Angola. Plains zebras, which are the most abundant of the three zebra species, are found from the grasslands of East Africa to the scrubby woodlands of southern Africa. They are one of Africa’s most successful and adaptable large herbivores. A subspecies of the plains zebra, the Grant’s zebra, is famous for its spectacular migrations during the rainy season in the Serengeti, when as many as 10,000 of these animals can be seen journeying together in congregated herds.\n" +
                "\n" +
                "Zebras are herbivores and feed mostly by grazing on grasses, although they also might browse a bit on the leaves and stems of bushes. They graze for many hours each day, using their strong front teeth to clip off the tips of the grass. Their back teeth then crush and grind the food. Spending so much time chewing wears the teeth down, so those teeth keep growing all their lives.\n" +
                "\n" +
                "As the dry season arrives and the grasses die back, zebra herds travel to find more food and water holes for drinking. Most zebras are considered nomadic, without specific territories. The exception is the Grevy's zebra. Stallions of this species mark out territories with urine and dung. The mares, their foals, and immature males wander through as they wish. If food becomes scarce, though, the stallions leave their territories for a while and travel with the larger herds.\n" +
                "\n" +
                "Zebras at the San Diego Zoo and the San Diego Zoo Safari Park are fed hay, alfalfa, and carrots.\n" +
                "\n" +
                "FAMILY LIFE\n" +
                "Scratch my back and I’ll scratch yours: Plains and mountain zebras are social herd animals, living in family groups with a stallion, several mares, and their offspring. During certain times of the year, these groups gather together to form loosely associated herds of up to several hundred, but the family groups still stay together within these larger groups. Grevy’s zebras do not have a herd system, and males and females have no permanent bonds. Grevy’s zebra stallions establish territories, with mares crossing through them to breed and foal. Once the foals are old enough to travel, the mares usually leave the protection of the stallion’s territory to continue their nomadic lifestyle.\n" +
                "\n" +
                "Zebras communicate with one another with facial expressions and sounds. They make loud braying or barking sounds and soft snorts and whuffs. The position of their ears, how wide open their eyes are, and whether their mouths are open or their teeth are bared all mean something. Ears flat back, for example, means trouble, or you better follow orders! Zebras also reinforce their bonds by grooming each other. You might see two zebras standing head to back, apparently biting each other, but they are really only nibbling on each other with their teeth to pull out loose hair and get a good scratch.\n" +
                "\n" +
                "Like domestic horses, zebras put a good deal of energy into raising their offspring. Zebra foals have soft, fuzzy fur, and their stripes are usually brown and white at first. Their legs are already almost as long as an adult zebra’s and they can walk just 20 minutes after birth and can run after an hour! This is important, since the mare needs to move with the herd to find food and water. She cannot leave the foal behind, so it must be up and running quickly in order to stay with the family.\n" +
                "\n" +
                "Foals must be able to recognize their mother from birth in order to survive. A foal learns its mother’s stripe pattern in order to follow her. Mares usually do not adopt other foals, so there would be no chance of getting food from anyone but Mom. Mothers often separate from the herd a short distance so that their foals can imprint on them. Once the foal can readily identify its mother, the mare and her foal return to the herd for protection."))


        adapter = AnimalAdapter(this, listOfAnimals)
        tvListAnimal.adapter = adapter

    }

        inner class AnimalAdapter : BaseAdapter {

            var listOfAnimals = ArrayList<Animal>()
            var context: Context? = null

            constructor(context: Context, listOfAnimals: ArrayList<Animal>) : super() {
                this.listOfAnimals = listOfAnimals
                this.context = context
            }

            override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
                var animal = listOfAnimals[p0]
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.animal_ticket, null)
                myView.tvName.text = animal.name!!
                myView.tvDes.text = animal.des!!
                myView.ivAnimalImage.setImageResource(animal.image!!)

                myView.ivAnimalImage.setOnClickListener {
                    val intent = Intent(context, AnimalInfo::class.java)

                    intent.putExtra("name", animal.name!!)
                    intent.putExtra("des", animal.des2!!)
                    intent.putExtra("image", animal.image!!)
                    context!!.startActivity(intent)
                }

                return myView
            }

            override fun getItem(p0: Int): Any {
                return listOfAnimals[p0]
            }

            override fun getItemId(p0: Int): Long {
                return p0.toLong()
            }

            override fun getCount(): Int {
                return listOfAnimals.size
            }

        }
    }

