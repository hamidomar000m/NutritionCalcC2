package backend;

public class NutritionCalculator {
	//test
	// user data
	private String gender;
	private String goal;
	private String activity;
	private int age;
	private double height;
	private double weight;

	// nutritional values
	private int totalRequirements;
	private int proteins;
	private int fats;
	private int carbs;

	// vitamins
	private String vitaminA; // mg
	private String vitaminB1; // mg
	private String vitaminB2; // mg
	private String vitaminB3; // mg
	private String vitaminB5; // mg
	private String vitaminB6; // mg
	private String vitaminB7; // g
	private String vitaminB9; // g
	private String vitaminB12; // g
	private String vitaminC; // mg
	private String vitaminD; // g
	private String vitaminE; // mg
	private String vitaminK; // g

	// minerals
	private String calcium; // g
	private String chlorid; // g
	private String kalium; // g
	private String magnesium; // g
	private String phosphat; // g
	private String schwefel; // g

	// trace elements
	private String chrom; // g
	private String eisen; // g
	private String iod; // g
	private String kupfer; // mg
	private String mangan; // mg
	private String molybdaen; // g
	private String selen; // g
	private String zink; // mg

	// essential amino acids
	private String leucin; // mg
	private String lysin; // mg
	private String methionin; // mg
	private String phenylalanin;// g
	private String tryptophan; // mg

	// Unsaturated fatty acids
	private String ala; // mg
	private String epa_dha; // g

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

		// determine the activity factor:
		double activityFactor;
		
		switch (activity) {
		case "Exclusively seated/lying activities":
			activityFactor = 1.2;
			break;
		case "Very often sedentary activities":
			activityFactor = 1.4;
			break;
		case "Predominantly sedentary activities":
			activityFactor = 1.65;
			break;
		case "Predominantly walking / standing activity":
			activityFactor = 1.85;
			break;
		case "Vigorous physical activity":
			activityFactor = 2.2;
			break;
		default:
			activityFactor = 0;
		}

		// calculate the calorie requirement:
		double basicRequirements;
		double additionalRequirements;

		switch (gender) {
		case "male":
			basicRequirements = 66.47 + 13.7 * weight + 5 * height - 6.8 * age;
			additionalRequirements = basicRequirements * (activityFactor - 1);
			totalRequirements = (int) Math.round(basicRequirements + additionalRequirements);
			break;
		case "female":
			basicRequirements = 655.1 + 9.6 * weight + 1.8 * height - 4.7 * age;
			additionalRequirements = basicRequirements * (activityFactor - 1);
			totalRequirements = (int) Math.round(basicRequirements + additionalRequirements);
			break;
		}

		// calculate the nutrient distribution:
		switch (gender) {
		case "male":
			switch (goal) {
			case "gain muscles":
				totalRequirements = totalRequirements + 400;
				proteins = (int) Math.round((totalRequirements*0.3) / 4.1);
				fats = (int) Math.round((totalRequirements*0.2) / 9.3);
				carbs = (int) Math.round((totalRequirements*0.5) / 4.1);

				vitaminA = "1.2 mg";
				vitaminB1 = "1.5 mg";
				if (age >= 50) {
					vitaminB2 = "1.3 mg";
				} else {
					vitaminB2 = "1.5 mg";
				}
				vitaminB3 = Double.valueOf((Math.round((6.9 * (totalRequirements / 1000)) * 10) / 10.0)).toString()
						+ " mg";
				vitaminB5 = "6.4 mg";
				vitaminB6 = "1.8 mg";
				vitaminB7 = "60 mcg";
				vitaminB9 = "300 mcg";
				vitaminB12 = "6 mcg";
				vitaminC = "110 mg";
				vitaminD = "50 mcg";
				vitaminE = "15 mg";
				vitaminK = "80 mcg";

				calcium = "1.5 g";
				chlorid = "1.5 g";
				kalium = "5 g";
				magnesium = "0.5 g";
				phosphat = "1.25 g";
				schwefel = "1 g";

				chrom = "100 mcg";
				eisen = "15 mcg";
				iod = "200 mcg";
				kupfer = "1.8 mg";
				mangan = "5 mg";
				molybdaen = "100 mcg";
				selen = "90 mcg";
				zink = "12 mg";

				leucin = Double.valueOf(25 * weight).toString() + " mg";
				lysin = Double.valueOf(25 * weight).toString() + " mg";
				methionin = Double.valueOf(25 * weight).toString() + " mg";
				phenylalanin = "0.9 g";
				tryptophan = Double.valueOf(4.5 * weight).toString() + " mg";

				ala = "600 mg";
				epa_dha = "2 g";

				break;
			case "muscle definition":
				totalRequirements = totalRequirements - 400;
				proteins = (int) Math.round((totalRequirements*0.3) / 4.1);
				fats = (int) Math.round((totalRequirements*0.3) / 9.3);
				carbs = (int) Math.round((totalRequirements*0.4) / 4.1);

				vitaminA = "1 mg";
				vitaminB1 = "1.4 mg";
				if (age >= 50) {
					vitaminB2 = "1.3 mg";
				} else {
					vitaminB2 = "1.4 mg";
				}
				vitaminB3 = Double.valueOf((Math.round((6.6 * (totalRequirements / 1000)) * 10) / 10.0)).toString()
						+ " mg";
				vitaminB5 = "6 mg";
				vitaminB6 = "1.6 mg";
				vitaminB7 = "50 mcg";
				vitaminB9 = "300 mcg";
				vitaminB12 = "5.5 mcg";
				vitaminC = "110 mg";
				vitaminD = "40 mcg";
				vitaminE = "14 mg";
				vitaminK = "76 mcg";

				calcium = "1.25 g";
				chlorid = "1.25 g";
				kalium = "4.5 g";
				magnesium = "0.45 g";
				phosphat = "1 g";
				schwefel = "0.8 g";

				chrom = "80 mcg";
				eisen = "15 mcg";
				iod = "175 mcg";
				kupfer = "1.8 mg";
				mangan = "4 mg";
				molybdaen = "75 mcg";
				selen = "80 mcg";
				zink = "11 mg";

				leucin = Double.valueOf(22 * weight).toString() + " mg";
				lysin = Double.valueOf(22 * weight).toString() + " mg";
				methionin = Double.valueOf(22 * weight).toString() + " mg";
				phenylalanin = "0.8 g";
				tryptophan = Double.valueOf(4.5 * weight).toString() + " mg";

				ala = "600 mg";
				epa_dha = "2 g";

				break;
			case "lose weight":
				totalRequirements = totalRequirements - 400;
				proteins = (int) Math.round((totalRequirements*0.3) / 4.1);
				fats = (int) Math.round((totalRequirements*0.35) / 9.3);
				carbs = (int) Math.round((totalRequirements*0.35) / 4.1);

				vitaminA = "1 mg";
				vitaminB1 = "1.3 mg";
				vitaminB2 = "1.3 mg";
				vitaminB3 = Double.valueOf((Math.round((6.6 * (totalRequirements / 1000)) * 10) / 10.0)).toString()
						+ " mg";
				vitaminB5 = "6 mg";
				vitaminB6 = "1.6 mg";
				vitaminB7 = "45 mcg";
				vitaminB9 = "300 mcg";
				vitaminB12 = "5.2 mcg";
				vitaminC = "110 mg";
				vitaminD = "35 mcg";
				vitaminE = "13.5 mg";
				vitaminK = "75 mcg";

				calcium = "1.2 g";
				chlorid = "1.2 g";
				kalium = "4.4 g";
				magnesium = "0.35 g";
				phosphat = "0.9 g";
				schwefel = "0.75 g";

				chrom = "40 mcg";
				eisen = "10 mcg";
				iod = "170 mcg";
				kupfer = "1.5 mg";
				mangan = "3.5 mg";
				molybdaen = "70 mcg";
				selen = "75 mcg";
				zink = "11 mg";

				leucin = Double.valueOf(15 * weight).toString() + " mg";
				lysin = Double.valueOf(12 * weight).toString() + " mg";
				methionin = Double.valueOf(13 * weight).toString() + " mg";
				phenylalanin = "0.6 mg";
				tryptophan = Double.valueOf(3.5 * weight).toString() + " mg";

				ala = "400 mg";
				epa_dha = "0.9 g";

				break;
			case "hold weight":
				proteins = (int) Math.round((totalRequirements*0.2) / 4.1);
				fats = (int) Math.round((totalRequirements*0.3) / 9.3);
				carbs = (int) Math.round((totalRequirements*0.5) / 4.1);

				vitaminA = "1 mg";
				vitaminB1 = "1.4 mg";
				if (age >= 50) {
					vitaminB2 = "1.3 mg";
				} else {
					vitaminB2 = "1.4 mg";
				}
				vitaminB3 = Double.valueOf((Math.round((6.6 * (totalRequirements / 1000)) * 10) / 10.0)).toString()
						+ " mg";
				vitaminB5 = "6 mg";
				vitaminB6 = "1.6 mg";
				vitaminB7 = "45 mcg";
				vitaminB9 = "300 mcg";
				vitaminB12 = "5 mcg";
				vitaminC = "110 mg";
				vitaminD = "40 mcg";
				vitaminE = "14 mg";
				vitaminK = "76 mcg";

				calcium = "1.2 g";
				chlorid = "1.2 g";
				kalium = "4.5 g";
				magnesium = "0.35 g";
				phosphat = "0.9 g";
				schwefel = "0.7 g";

				chrom = "50 mcg";
				eisen = "10 mcg";
				iod = "175 mcg";
				kupfer = "1.6 mg";
				mangan = "4 mg";
				molybdaen = "75 mcg";
				selen = "80 mcg";
				zink = "12 mg";

				leucin = Double.valueOf(15 * weight).toString() + " mg";
				lysin = Double.valueOf(12 * weight).toString() + " mg";
				methionin = Double.valueOf(13 * weight).toString() + " mg";
				phenylalanin = "0.6 g";
				tryptophan = Double.valueOf(3.5 * weight).toString() + " mg";

				ala = "400 mg";
				epa_dha = "0.9 g";

				break;
			}
			break;

		case "female":
			switch (goal) {
			case "gain muscles":
				totalRequirements = totalRequirements + 400;
				proteins = (int) Math.round((totalRequirements*0.3) / 4.1);
				fats = (int) Math.round((totalRequirements*0.2) / 9.3);
				carbs = (int) Math.round((totalRequirements*0.5) / 4.1);

				vitaminA = "1 mg";
				vitaminB1 = "1.3 mg";
				if (age >= 50) {
					vitaminB2 = "1.3 mg";
				} else {
					vitaminB2 = "1.2 mg";
				}
				vitaminB3 = Double.valueOf((Math.round((5.8 * (totalRequirements / 1000)) * 10) / 10.0)).toString()
						+ " mg";
				vitaminB5 = "6 mg";
				vitaminB6 = "1.6 mg";
				vitaminB7 = "55 mcg";
				vitaminB9 = "300 mcg";
				vitaminB12 = "5.8 mcg";
				vitaminC = "95 mg";
				vitaminD = "45 mcg";
				vitaminE = "12 mg";
				vitaminK = "65 mcg";

				calcium = "1.3 g";
				chlorid = "1.3 g";
				kalium = "4.5 g";
				magnesium = "0.4 g";
				phosphat = "1.1 g";
				schwefel = "1 g";

				chrom = "80 mcg";
				eisen = "20 mcg";
				iod = "190 mcg";
				kupfer = "1.8 mg";
				mangan = "5 mg";
				molybdaen = "90 mcg";
				selen = "65 mcg";
				zink = "9 mg";

				leucin = Double.valueOf(22 * weight).toString() + " mg";
				lysin = Double.valueOf(22 * weight).toString() + " mg";
				methionin = Double.valueOf(22 * weight).toString() + " mg";
				phenylalanin = "0.8 g";
				tryptophan = Double.valueOf(4.25 * weight).toString() + " mg";

				ala = "600 mg";
				epa_dha = "2 g";

				break;
			case "muscle definition":
				totalRequirements = totalRequirements - 400;
				proteins = (int) Math.round((totalRequirements*0.3) / 4.1);
				fats = (int) Math.round((totalRequirements*0.3) / 9.3);
				carbs = (int) Math.round((totalRequirements*0.4) / 4.1);

				vitaminA = "1 mg";
				vitaminB1 = "1.2 mg";
				if (age >= 50) {
					vitaminB2 = "1.3 mg";
				} else {
					vitaminB2 = "1.1 mg";
				}
				vitaminB3 = Double.valueOf((Math.round((5.5 * (totalRequirements / 1000)) * 10) / 10.0)).toString()
						+ " mg";
				vitaminB5 = "6 mg";
				vitaminB6 = "1.4 mg";
				vitaminB7 = "50 mcg";
				vitaminB9 = "300 mcg";
				vitaminB12 = "5.5 mcg";
				vitaminC = "95 mg";
				vitaminD = "40 mcg";
				vitaminE = "11 mg";
				vitaminK = "65 mcg";

				calcium = "1.2 g";
				chlorid = "1.2 g";
				kalium = "4.4 g";
				magnesium = "0.35 g";
				phosphat = "1 g";
				schwefel = "0.8 g";

				chrom = "70 mcg";
				eisen = "18 mcg";
				iod = "180 mcg";
				kupfer = "1.6 mg";
				mangan = "4 mg";
				molybdaen = "80 mcg";
				selen = "60 mcg";
				zink = "8 mg";

				leucin = Double.valueOf(22 * weight).toString() + " mg";
				lysin = Double.valueOf(22 * weight).toString() + " mg";
				methionin = Double.valueOf(22 * weight).toString() + " mg";
				phenylalanin = "0.7 g";
				tryptophan = Double.valueOf(4.25 * weight).toString() + " mg";

				ala = "600 mg";
				epa_dha = "2 g";

				break;
			case "lose weight":
				totalRequirements = totalRequirements - 400;
				proteins = (int) Math.round((totalRequirements*0.3) / 4.1);
				fats = (int) Math.round((totalRequirements*0.35) / 9.3);
				carbs = (int) Math.round((totalRequirements*0.35) / 4.1);

				vitaminA = "0.8 mg";
				vitaminB1 = "1.1 mg";
				if (age >= 50) {
					vitaminB2 = "1.3 mg";
				} else {
					vitaminB2 = "1.1 mg";
				}
				vitaminB3 = Double.valueOf((Math.round((5.5 * (totalRequirements / 1000)) * 10) / 10.0)).toString()
						+ " mg";
				vitaminB5 = "5.8 mg";
				vitaminB6 = "1.4 mg";
				vitaminB7 = "40 mcg";
				vitaminB9 = "300 mcg";
				vitaminB12 = "4.5 mcg";
				vitaminC = "95 mg";
				vitaminD = "30 mcg";
				vitaminE = "10 mg";
				vitaminK = "60 mcg";

				calcium = "1 g";
				chlorid = "1 g";
				kalium = "4 g";
				magnesium = "0.3 g";
				phosphat = "0.9 g";
				schwefel = "0.7 g";

				chrom = "60 mcg";
				eisen = "15 mcg";
				iod = "170 mcg";
				kupfer = "1.5 mg";
				mangan = "4 mg";
				molybdaen = "75 mcg";
				selen = "60 mcg";
				zink = "7.5 mg";

				leucin = Double.valueOf(15 * weight).toString() + " mg";
				lysin = Double.valueOf(12 * weight).toString() + " mg";
				methionin = Double.valueOf(13 * weight).toString() + " mg";
				phenylalanin = "0.6 g";
				tryptophan = Double.valueOf(3.5 * weight).toString() + " mg";

				ala = "300 mg";
				epa_dha = "0.9 g";

				break;
			case "hold weight":
				proteins = (int) Math.round((totalRequirements*0.2) / 4.1);
				fats = (int) Math.round((totalRequirements*0.3) / 9.3);
				carbs = (int) Math.round((totalRequirements*0.5) / 4.1);

				vitaminA = "0.8 mg";
				vitaminB1 = "1.2 mg";
				if (age >= 50) {
					vitaminB2 = "1.3 mg";
				} else {
					vitaminB2 = "1.1 mg";
				}
				vitaminB3 = Double.valueOf((Math.round((5.5 * (totalRequirements / 1000)) * 10) / 10.0)).toString()
						+ " mg";
				vitaminB5 = "6 mg";
				vitaminB6 = "1.4 mg";
				vitaminB7 = "45 mcg";
				vitaminB9 = "300 mcg";
				vitaminB12 = "5 mcg";
				vitaminC = "95 mg";
				vitaminD = "35 mcg";
				vitaminE = "11 mg";
				vitaminK = "60 mcg";

				calcium = "1 g";
				chlorid = "1 g";
				kalium = "4 g";
				magnesium = "0.3 g";
				phosphat = "0.9 g";
				schwefel = "0.7 g";

				chrom = "70 mcg";
				eisen = "15 mcg";
				iod = "175 mcg";
				kupfer = "1.6 mg";
				mangan = "4 mg";
				molybdaen = "75 mcg";
				selen = "60 mcg";
				zink = "8 mg";

				leucin = Double.valueOf(15 * weight).toString() + " mg";
				lysin = Double.valueOf(12 * weight).toString() + " mg";
				methionin = Double.valueOf(13 * weight).toString() + " mg";
				phenylalanin = "0.6 g";
				tryptophan = Double.valueOf(3.5 * weight).toString() + " mg";

				ala = "300 mg";
				epa_dha = "0.9 g";

				break;
			}
		}

		System.out.println("Nutrients calculated");
	}
	
	
	
	/*
	 * calculates the overall nutritional values
	 * based on the user input in the tracking frame
	 */
	public static void calculateTrackingValues(double[] trackingData) {
		
	}
	
	

	/*
	 * return the results of the calculation
	 * 
	 * each "group" of nutrient is returned in an own method
	 */
	public double[] getNutritionalValues() {
		double[] nutritionalValues = { totalRequirements, proteins, fats, carbs };
		return nutritionalValues;
	}

	public String[] getNutrients() {
		String[] nutrients = { vitaminA, vitaminB1, vitaminB2, vitaminB3, vitaminB5, vitaminB6, vitaminB7, vitaminB9,
				vitaminB12, vitaminC, vitaminD, vitaminE, vitaminK, calcium, chlorid, kalium, magnesium, phosphat,
				schwefel, chrom, eisen, iod, kupfer, mangan, molybdaen, selen, zink, leucin, lysin, methionin,
				phenylalanin, tryptophan, ala, epa_dha };
		return nutrients;
	}

	public String[] getNames() {
		String[] names = { "Vitamin A", "Thiamin", "Riboflavin", "Niacin", "Pantothensaeure", "Vitamin B6", "Biotin",
				"Folsaeure", "Vitamin B12", "Vitamin C", "Vitamin D", "Vitamin E", "Vitamin K", "Calcium", "Chlorid",
				"Kalium", "Magnesium", "Phosphat", "Schwefel", "Chrom", "Eisen", "Iod", "Kupfer", "Mangan", "Molybdaen",
				"Selen", "Zink", "Leucin", "Lysin", "Methionin", "Phenylalanin", "Tryptophan", "ALA", "EPA und DHA" };
		return names;
	}

	// ------------------------------------------//
	// ------------------------------------------//
	/*
	 * some code for test purposes
	 */
	/*
	 * public void printUserData() { System.out.println(this.gender + "\n" +
	 * this.age + "\n" + this.height + "\n" + this.weight + "\n" + this.goal + "\n"
	 * + this.activity + "\n\n\n"); }
	 * 
	 * public void printNutritionalValues() { System.out.println("Kalorien: " +
	 * totalRequirements); System.out.println("Proteine: " + proteins);
	 * System.out.println("Fette: " + fats); System.out.println("Kohlenhydrate: " +
	 * carbs + "\n"); }
	 * 
	 * public String[] names = {"Vitamin A", "Thiamin", "Riboflavin", "Niacin",
	 * "Pantothensure", "Vitamin B6", "Biotin", "Folsure", "Vitamin B12",
	 * "Vitamin C", "Vitamin D", "Vitamin E", "Vitamin K", "Calcium", "Chlorid",
	 * "Kalium", "Magnesium", "Phosphat", "Schwefel", "Chrom", "Eisen", "Iod",
	 * "Kupfer", "Mangan", "Molybdn", "Selen", "Zink", "Leucin", "Lysin",
	 * "Methionin", "Phenylalanin", "Tryptophan", "ALA", "EPA und DHA"};
	 * 
	 * public void printAll() { double[] values = {vitaminA, vitaminB1, vitaminB2,
	 * vitaminB3, vitaminB5, vitaminB6, vitaminB7, vitaminB9, vitaminB12, vitaminC,
	 * vitaminD, vitaminE, vitaminK, calcium, chlorid, kalium, magnesium, phosphat,
	 * schwefel, chrom, eisen, iod, kupfer, mangan, molybdaen, selen, zink, leucin,
	 * lysin, methionin, phenylalanin, tryptophan, ala, epa_dha}; for(int i = 0; i <
	 * names.length; i++) { System.out.println(names[i] + ": " + values[i]); } }
	 */

}
