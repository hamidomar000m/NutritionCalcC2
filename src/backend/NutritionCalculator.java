package backend;


public class NutritionCalculator {
	
	//user data
	private String gender;
	private String goal;
	private String activity;
	private int age;
	private double height;
	private double weight;
	
	//nutritional values
	private double totalRequirements;
	private double proteins;
	private double fats;
	private double carbs;
	
	//vitamins
	private double vitaminA;	//mg
	private double vitaminB1;	//mg
	private double vitaminB2;	//mg
	private double vitaminB3;	//mg
	private double vitaminB5;	//mg
	private double vitaminB6;	//mg
	private double vitaminB7;	//g
	private double vitaminB9;	//g
	private double vitaminB12;	//g
	private double vitaminC;	//mg
	private double vitaminD;	//g
	private double vitaminE;	//mg
	private double vitaminK;	//g
	
	//minerals
	private double calcium;		//g
	private double chlorid;		//g
	private double kalium;		//g
	private double magnesium;	//g
	private double phosphat;	//g
	private double schwefel;	//g
	
	//trace elements
	private double chrom;		//g
	private double eisen;		//g
	private double iod;			//g
	private double kupfer;		//mg
	private double mangan;		//mg
	private double molybdaen;	//g
	private double selen;		//g
	private double zink;		//mg
	
	//essential amino acids
	private double leucin;		//mg
	private double lysin;		//mg
	private double methionin;	//mg
	private double phenylalanin;//g
	private double tryptophan;	//mg
	
	//Unsaturated fatty acids
	private double ala;			//mg
	private double epa_dha;		//g
	
	/*
	 * create a calculator containing all necessary information
	 */
	public NutritionCalculator(String gender, int age, double height, double weight, String goal, String activity) {
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.goal = goal;
		this.activity = activity;
	}
	
	
	
	/*
	 * calculate the nutrient distribution
	 */
	public void calculate() {
		
		//determine the activity factor:
		double activityFactor;
		
		switch(activity) {
		case "Exclusively seated / lying activities":
			activityFactor = 1.2;
			break;
		case "Almost exclusively sedentary activities with almost no physical activity in the leisure":
			activityFactor = 1.4;
			break;
		case "Predominantly sedentary activities with occasional standing / walking activity":
			activityFactor = 1.65;
			break;
		case "Predominantly walking / standing activity":
			activityFactor = 1.85;
			break;
		case "Vigorous physical activity":
			activityFactor = 2.2;
			break;
		default: activityFactor = 0;
		}
		
		
		//calculate the calorie requirement:
		double basicRequirements;
		double additionalRequirements;
		
		switch(gender) {
		case "male":
			basicRequirements = 66.47 + 13.7*weight + 5*height - 6.8*age;
			additionalRequirements = basicRequirements * (activityFactor - 1);
			totalRequirements = basicRequirements + additionalRequirements;
			break;
		case "female":
			basicRequirements = 655.1 + 9.6*weight + 1.8*height - 4.7*age;
			additionalRequirements = basicRequirements * (activityFactor - 1);
			totalRequirements = basicRequirements + additionalRequirements;
			break;
		}
		
		//calculate the nutrient distribution:
		switch(gender) {
		case "male":
			switch(goal) {
			case "gain muscles":
				totalRequirements = totalRequirements + 400;
				proteins = 2.6*weight;
				fats = 1.2*weight;
				carbs = (totalRequirements - proteins*4.1 - fats*9.3) / 4.1;
				
				vitaminA = 1.2;
				vitaminB1 = 1.5;
				if(age >= 50) {vitaminB2 = 1.3;}
				else {vitaminB2 = 1.5;}
				vitaminB3 = 6.9 * (totalRequirements/1000);
				vitaminB5 = 6.4;
				vitaminB6 = 1.8;
				vitaminB7 = 60;
				vitaminB9 = 300;
				vitaminB12 = 6;
				vitaminC = 110;
				vitaminD = 50;
				vitaminE = 15;
				vitaminK = 80;
				
				calcium = 1.5;
				chlorid = 1.5;
				kalium = 5;
				magnesium = 0.5;
				phosphat = 1.25;
				schwefel = 1;
				
				chrom = 100;
				eisen = 15;
				iod = 200;
				kupfer = 1.8;
				mangan = 5;
				molybdaen = 100;
				selen = 90;
				zink = 12;
				
				leucin = 25*weight;
				lysin = 25*weight;
				methionin = 25*weight;
				phenylalanin = 0.9;
				tryptophan = 4.5*weight;
				
				ala = 600;
				epa_dha = 2;
				
				break;
			case "muscle definition":
				totalRequirements = totalRequirements - 400;
				proteins = 2.5*weight;
				fats = 1.6*weight;
				carbs = (totalRequirements - proteins*4.1 - fats*9.3) / 4.1;
				
				vitaminA = 1;
				vitaminB1 = 1.4;
				if(age >= 50) {vitaminB2 = 1.3;}
				else {vitaminB2 = 1.4;}
				vitaminB3 = 6.6 * (totalRequirements/1000);
				vitaminB5 = 6;
				vitaminB6 = 1.6;
				vitaminB7 = 50;
				vitaminB9 = 300;
				vitaminB12 = 5.5;
				vitaminC = 110;
				vitaminD = 40;
				vitaminE = 14;
				vitaminK = 76;
				
				calcium = 1.25;
				chlorid = 1.25;
				kalium = 4.5;
				magnesium = 0.45;
				phosphat = 1;
				schwefel = 0.8;
				
				chrom = 80;
				eisen = 15;
				iod = 175;
				kupfer = 1.8;
				mangan = 4;
				molybdaen = 75;
				selen = 80;
				zink = 11;
				
				leucin = 22*weight;
				lysin = 22*weight;
				methionin = 22*weight;
				phenylalanin = 0.8;
				tryptophan = 4.5*weight;
				
				ala = 600;
				epa_dha = 2;
				
				break;
			case "lose weight":
				totalRequirements = totalRequirements - 400;
				proteins = 1.9*weight;
				fats = 0.8*weight;
				carbs = (totalRequirements - proteins*4.1 - fats*9.3) / 4.1;
				
				vitaminA = 1;
				vitaminB1 = 1.3;
				vitaminB2 = 1.3;
				vitaminB3 = 6.6 * (totalRequirements/1000);
				vitaminB5 = 6;
				vitaminB6 = 1.6;
				vitaminB7 = 45;
				vitaminB9 = 300;
				vitaminB12 = 5.2;
				vitaminC = 110;
				vitaminD = 35;
				vitaminE = 13.5;
				vitaminK = 75;
				
				calcium = 1.2;
				chlorid = 1.2;
				kalium = 4.4;
				magnesium = 0.35;
				phosphat = 0.9;
				schwefel = 0.75;
				
				chrom = 40;
				eisen = 10;
				iod = 170;
				kupfer = 1.5;
				mangan = 3.5;
				molybdaen = 70;
				selen = 75;
				zink = 11;
				
				leucin = 15*weight;
				lysin = 12*weight;
				methionin = 13*weight;
				phenylalanin = 0.6;
				tryptophan = 3.5*weight;
				
				ala = 400;
				epa_dha = 0.9;
				
				break;
			case "hold weight":
				proteins = 1.9*weight;
				fats = weight;
				carbs = (totalRequirements - proteins*4.1 - fats*9.3) / 4.1;
				
				vitaminA = 1;
				vitaminB1 = 1.4;
				if(age >= 50) {vitaminB2 = 1.3;}
				else {vitaminB2 = 1.4;}
				vitaminB3 = 6.6 * (totalRequirements/1000);
				vitaminB5 = 6;
				vitaminB6 = 1.6;
				vitaminB7 = 45;
				vitaminB9 = 300;
				vitaminB12 = 5;
				vitaminC = 110;
				vitaminD = 40;
				vitaminE = 14;
				vitaminK = 76;
				
				calcium = 1.2;
				chlorid = 1.2;
				kalium = 4.5;
				magnesium = 0.35;
				phosphat = 0.9;
				schwefel = 0.7;
				
				chrom = 50;
				eisen = 10;
				iod = 175;
				kupfer = 1.6;
				mangan = 4;
				molybdaen = 75;
				selen = 80;
				zink = 12;
				
				leucin = 15*weight;
				lysin = 12*weight;
				methionin = 13*weight;
				phenylalanin = 0.6;
				tryptophan = 3.5*weight;
				
				ala = 400;
				epa_dha = 0.9;
				
				break;
			}
			break;
			
		case "female":
			switch(goal) {
			case "gain muscles":
				totalRequirements = totalRequirements + 400;
				proteins = 2.5*weight;
				fats = 1.2*weight;
				carbs = (totalRequirements - proteins*4.1 - fats*9.3) / 4.1;
				
				vitaminA = 1;
				vitaminB1 = 1.3;
				if(age >= 50) {vitaminB2 = 1.3;}
				else {vitaminB2 = 1.2;}
				vitaminB3 = 5.8 * (totalRequirements/1000);
				vitaminB5 = 6;
				vitaminB6 = 1.6;
				vitaminB7 = 55;
				vitaminB9 = 300;
				vitaminB12 = 5.8;
				vitaminC = 95;
				vitaminD = 45;
				vitaminE = 12;
				vitaminK = 65;
				
				calcium = 1.3;
				chlorid = 1.3;
				kalium = 4.5;
				magnesium = 0.4;
				phosphat = 1.1;
				schwefel = 1;
				
				chrom = 80;
				eisen = 20;
				iod = 190;
				kupfer = 1.8;
				mangan = 5;
				molybdaen = 90;
				selen = 65;
				zink = 9;
				
				leucin = 22*weight;
				lysin = 22*weight;
				methionin = 22*weight;
				phenylalanin = 0.8;
				tryptophan = 4.25*weight;
				
				ala = 600;
				epa_dha = 2;
				
				break;
			case "muscle definition":
				totalRequirements = totalRequirements - 400;
				proteins = 2.4*weight;
				fats = 1.6*weight;
				carbs = (totalRequirements - proteins*4.1 - fats*9.3) / 4.1;
				
				vitaminA = 1;
				vitaminB1 = 1.2;
				if(age >= 50) {vitaminB2 = 1.3;}
				else {vitaminB2 = 1.1;}
				vitaminB3 = 5.5 * (totalRequirements/1000);
				vitaminB5 = 6;
				vitaminB6 = 1.4;
				vitaminB7 = 50;
				vitaminB9 = 300;
				vitaminB12 = 5.5;
				vitaminC = 95;
				vitaminD = 40;
				vitaminE = 11;
				vitaminK = 65;
				
				calcium = 1.2;
				chlorid = 1.2;
				kalium = 4.4;
				magnesium = 0.35;
				phosphat = 1;
				schwefel = 0.8;
				
				chrom = 70;
				eisen = 18;
				iod = 180;
				kupfer = 1.6;
				mangan = 4;
				molybdaen = 80;
				selen = 60;
				zink = 8;
				
				leucin = 22*weight;
				lysin = 22*weight;
				methionin = 22*weight;
				phenylalanin = 0.7;
				tryptophan = 4.25*weight;
				
				ala = 600;
				epa_dha = 2;
				
				break;
			case "lose weight":
				totalRequirements = totalRequirements - 400;
				proteins = 1.9*weight;
				fats = 0.8*weight;
				carbs = (totalRequirements - proteins*4.1 - fats*9.3) / 4.1;
				
				vitaminA = 0.8;
				vitaminB1 = 1.1;
				if(age >= 50) {vitaminB2 = 1.3;}
				else {vitaminB2 = 1.1;}
				vitaminB3 = 5.5 * (totalRequirements/1000);
				vitaminB5 = 5.8;
				vitaminB6 = 1.4;
				vitaminB7 = 40;
				vitaminB9 = 300;
				vitaminB12 = 4.5;
				vitaminC = 95;
				vitaminD = 30;
				vitaminE = 10;
				vitaminK = 60;
				
				calcium = 1;
				chlorid = 1;
				kalium = 4;
				magnesium = 0.3;
				phosphat = 0.9;
				schwefel = 0.7;
				
				chrom = 60;
				eisen = 15;
				iod = 170;
				kupfer = 1.5;
				mangan = 4;
				molybdaen = 75;
				selen = 60;
				zink = 7.5;
				
				leucin = 15*weight;
				lysin = 12*weight;
				methionin = 13*weight;
				phenylalanin = 0.6;
				tryptophan = 3.5*weight;
				
				ala = 300;
				epa_dha = 0.9;
				
				break;
			case "hold weight":
				proteins = 1.9*weight;
				fats = weight;
				carbs = (totalRequirements - proteins*4.1 - fats*9.3) / 4.1;
				
				vitaminA = 0.8;
				vitaminB1 = 1.2;
				if(age >= 50) {vitaminB2 = 1.3;}
				else {vitaminB2 = 1.1;}
				vitaminB3 = 5.5 * (totalRequirements/1000);
				vitaminB5 = 6;
				vitaminB6 = 1.4;
				vitaminB7 = 45;
				vitaminB9 = 300;
				vitaminB12 = 5;
				vitaminC = 95;
				vitaminD = 35;
				vitaminE = 11;
				vitaminK = 60;
				
				calcium = 1;
				chlorid = 1;
				kalium = 4;
				magnesium = 0.3;
				phosphat = 0.9;
				schwefel = 0.7;
				
				chrom = 70;
				eisen = 15;
				iod = 175;
				kupfer = 1.6;
				mangan = 4;
				molybdaen = 75;
				selen = 60;
				zink = 8;
				
				leucin = 15*weight;
				lysin = 12*weight;
				methionin = 13*weight;
				phenylalanin = 0.6;
				tryptophan = 3.5*weight;
				
				ala = 300;
				epa_dha = 0.9;
				
				break;
			}
		}
	}
	
	
	
	/*
	 * return the results of the calculation
	 * 
	 * each "group" of nutrient is returned in an own method
	 */
	public double[] getNutritionalValues() {
		double[] nutritionalValues = {totalRequirements, proteins, fats, carbs};
		return nutritionalValues;
	}
	
	public double[] getVitamins() {
		double[] vitamins = {vitaminA, vitaminB1, vitaminB2, vitaminB3, vitaminB5, vitaminB6,
							vitaminB7, vitaminB9, vitaminB12, vitaminC, vitaminD, vitaminE, vitaminK};
		return vitamins;
	}
	
	public double[] getMinerals() {
		double[] minerals = {calcium, chlorid, kalium, magnesium, phosphat, schwefel};
		return minerals;
	}
	
	public double[] getTraceElements() {
		double[] traceElements = {chrom, eisen, iod, kupfer, mangan, molybdaen, selen, zink};
		return traceElements;
	}
	
	public double[] getAminoAcids() {
		double[] aminoAcids = {leucin, lysin, methionin, phenylalanin, tryptophan};
		return aminoAcids;
	}
	
	public double[] getFattyAcids() {
		double[] fattyAcids = {ala, epa_dha};
		return fattyAcids;
	}
	
	
	//------------------------------------------//
	//------------------------------------------//
	/*
	 * some code for test purposes
	 */
	public void printUserData() {
		System.out.println(this.gender + "\n" + this.age + "\n" + this.height + "\n" + this.weight + "\n" + this.goal + "\n" + this.activity + "\n\n\n");
	}
	
	public void printNutritionalValues() {
		System.out.println("Kalorien: " + totalRequirements);
		System.out.println("Proteine: " + proteins);
		System.out.println("Fette: " + fats);
		System.out.println("Kohlenhydrate: " + carbs + "\n");
	}
	
	public String[] names = {"Vitamin A", "Thiamin", "Riboflavin", "Niacin", "Pantothensure", "Vitamin B6", "Biotin",
							"Folsure", "Vitamin B12", "Vitamin C", "Vitamin D", "Vitamin E", "Vitamin K", "Calcium",
							"Chlorid", "Kalium", "Magnesium", "Phosphat", "Schwefel", "Chrom", "Eisen", "Iod", "Kupfer",
							"Mangan", "Molybdn", "Selen", "Zink", "Leucin", "Lysin", "Methionin", "Phenylalanin",
							"Tryptophan", "ALA", "EPA und DHA"};
	
	public void printAll() {
		double[] values = {vitaminA, vitaminB1, vitaminB2, vitaminB3, vitaminB5, vitaminB6, vitaminB7,
				 vitaminB9, vitaminB12, vitaminC, vitaminD, vitaminE, vitaminK, calcium, chlorid,
				 kalium, magnesium, phosphat, schwefel, chrom, eisen, iod, kupfer, mangan, molybdaen,
				 selen, zink, leucin, lysin, methionin, phenylalanin, tryptophan, ala, epa_dha};
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i] + ": " + values[i]);
		}
	}

}

