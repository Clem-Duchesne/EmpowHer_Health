CREATE TABLE "users" (
  "id" integer PRIMARY KEY,
  "patient_id" integer,
  "username" varchar,
  "role" varchar,
  "email" varchar,
  "created_at" timestamp
);

CREATE TABLE "patients" (
  "id" integer PRIMARY KEY,
  "firstname" varchar,
  "lastname" varchar,
  "age" integer,
  "birthdate" date,
  "created_at" timestamp
);

CREATE TABLE "habits" (
  "id" integer PRIMARY KEY,
  "patient_id" integer,
  "frequency" integer,
  "frequency_type_id" integer,
  "dose_id" integer,
  "start_date" date,
  "end_date" date,
  "description" text,
  "created_at" timestamp
);

CREATE TABLE "smoking_habits" (
  "id" integer PRIMARY KEY,
  "habit_id" integer,
  "cigarettes_per_day" integer,
  "years_smoked" integer,
  "start_date" date,
  "end_date" date,
  "created_at" timestamp
);

CREATE TABLE "sleep_habits" (
  "id" integer PRIMARY KEY,
  "habit_id" integer,
  "average_hour_per_night" integer,
  "often_feel_tired_scale" integer,
  "fixed_sleep_hours" boolean,
  "sleep_quality" varchar,
  "wakeup_time" time,
  "bed_time" time,
  "created_at" timestamp
);

CREATE TABLE "alcohol_habits" (
  "id" integer PRIMARY KEY,
  "habit_id" integer,
  "drinks_per_week" float,
  "start_date" date,
  "end_date" date,
  "preferred_type" varchar,
  "created_at" timestamp
);

CREATE TABLE "physical_activity_habits" (
  "id" integer PRIMARY KEY,
  "habit_id" integer,
  "sessions_per_week" integer,
  "average_session_duration" float,
  "activity_type" varchar,
  "intensity" varchar,
  "created_at" timestamp
);

CREATE TABLE "diet_habits" (
  "id" integer PRIMARY KEY,
  "habit_id" integer,
  "diet_type" varchar,
  "average_water_intake" float,
  "carbs_deficit" boolean,
  "diet_quality" varchar,
  "created_at" timestamp
);

CREATE TABLE "stress_habits" (
  "id" integer PRIMARY KEY,
  "habit_id" integer,
  "stress_levels" float,
  "causes" text,
  "stressful_profession" boolean,
  "created_at" timestamp
);

CREATE TABLE "mental_health_habits" (
  "id" integer PRIMARY KEY,
  "habit_id" integer,
  "journaling" boolean,
  "journaling_scale" float,
  "therapy_sessions" boolean,
  "therapy_sessions_frequency" float,
  "meditation" boolean,
  "meditation_frequency" float,
  "medication" boolean,
  "treatment_id" integer,
  "created_at" timestamp
);

CREATE TABLE "menstrual_cycle_habits" (
  "id" integer PRIMARY KEY,
  "habit_id" integer,
  "cycle_length_days" integer,
  "average_period_duration" integer,
  "premenstrual_symptoms" varchar,
  "created_at" timestamp
);

CREATE TABLE "contraception_habits" (
  "id" integer PRIMARY KEY,
  "habit_id" integer,
  "type" varchar,
  "consistency" varchar,
  "created_at" timestamp
);

CREATE TABLE "medical_history" (
  "id" integer PRIMARY KEY,
  "patient_id" integer,
  "condition_id" integer,
  "diagnosis_date" date,
  "status_id" integer,
  "description" text,
  "created_at" timestamp
);

CREATE TABLE "family_medical_history" (
  "id" integer PRIMARY KEY,
  "patient_id" integer,
  "relative" varchar,
  "condition_id" integer,
  "description" text,
  "created_at" timestamp
);

CREATE TABLE "Status" (
  "id" integer PRIMARY KEY,
  "name" varchar,
  "created_at" timestamp
);

CREATE TABLE "medical_condition" (
  "id" integer PRIMARY KEY,
  "name" varchar,
  "created_at" timestamp
);

CREATE TABLE "treatments" (
  "id" integer PRIMARY KEY,
  "patient_id" integer,
  "name" varchar,
  "start_date" date,
  "end_date" date,
  "treatment_type_id" integer,
  "frequency" integer,
  "frequency_type_id" integer,
  "dose_id" integer,
  "created_at" timestamp
);

CREATE TABLE "treatment_types" (
  "id" integer PRIMARY KEY,
  "treatment_id" integer,
  "name" varchar,
  "created_at" timestamp
);

CREATE TABLE "frequency_types" (
  "id" integer PRIMARY KEY,
  "treatment_id" integer,
  "name" varchar,
  "created_at" timestamp
);

CREATE TABLE "Doses" (
  "id" integer PRIMARY KEY,
  "name" varchar,
  "created_at" timestamp
);

CREATE TABLE "Records" (
  "id" integer PRIMARY KEY,
  "record_date" date,
  "record_type" integer,
  "created_at" timestamp
);

CREATE TABLE "menstruation_records" (
  "id" integer PRIMARY KEY,
  "record_id" integer,
  "hasPMS" boolean,
  "pms" varchar,
  "pain" boolean,
  "pain_scale" integer,
  "duration" integer,
  "anomalies" varchar,
  "created_at" timestamp
);

CREATE TABLE "sleep_records" (
  "id" integer PRIMARY KEY,
  "scale_quality_sleep_during_week" integer,
  "average_time_sleep_during_week" integer,
  "anomalies" varchar,
  "record_id" integer,
  "created_at" timestamp
);

CREATE TABLE "mental_health_records" (
  "id" integer PRIMARY KEY,
  "record_id" integer,
  "scale_quality_mental_health" integer,
  "mental_fog_during_week" boolean,
  "mental_fog_scale" integer,
  "number_meditation_sessions" integer,
  "number_consultation_sessions" integer,
  "created_at" timestamp
);

CREATE TABLE "stress_records" (
  "id" integer PRIMARY KEY,
  "record_id" integer,
  "stress_levels_during_week" float,
  "causes" text,
  "created_at" timestamp
);

CREATE TABLE "users_patients" (
  "users_patient_id" integer,
  "patients_id" integer,
  PRIMARY KEY ("users_patient_id", "patients_id")
);

ALTER TABLE "users_patients" ADD FOREIGN KEY ("users_patient_id") REFERENCES "users" ("patient_id");

ALTER TABLE "users_patients" ADD FOREIGN KEY ("patients_id") REFERENCES "patients" ("id");


ALTER TABLE "patients" ADD FOREIGN KEY ("id") REFERENCES "treatments" ("patient_id");

ALTER TABLE "treatments" ADD FOREIGN KEY ("treatment_type_id") REFERENCES "treatment_types" ("treatment_id");

ALTER TABLE "treatments" ADD FOREIGN KEY ("frequency_type_id") REFERENCES "frequency_types" ("treatment_id");

ALTER TABLE "patients" ADD FOREIGN KEY ("id") REFERENCES "medical_history" ("patient_id");

ALTER TABLE "patients" ADD FOREIGN KEY ("id") REFERENCES "habits" ("patient_id");

CREATE TABLE "medical_history_medical_condition" (
  "medical_history_condition_id" integer,
  "medical_condition_id" integer,
  PRIMARY KEY ("medical_history_condition_id", "medical_condition_id")
);

ALTER TABLE "medical_history_medical_condition" ADD FOREIGN KEY ("medical_history_condition_id") REFERENCES "medical_history" ("condition_id");

ALTER TABLE "medical_history_medical_condition" ADD FOREIGN KEY ("medical_condition_id") REFERENCES "medical_condition" ("id");


CREATE TABLE "medical_history_Status" (
  "medical_history_status_id" integer,
  "Status_id" integer,
  PRIMARY KEY ("medical_history_status_id", "Status_id")
);

ALTER TABLE "medical_history_Status" ADD FOREIGN KEY ("medical_history_status_id") REFERENCES "medical_history" ("status_id");

ALTER TABLE "medical_history_Status" ADD FOREIGN KEY ("Status_id") REFERENCES "Status" ("id");


CREATE TABLE "patients_family_medical_history" (
  "patients_id" integer,
  "family_medical_history_patient_id" integer,
  PRIMARY KEY ("patients_id", "family_medical_history_patient_id")
);

ALTER TABLE "patients_family_medical_history" ADD FOREIGN KEY ("patients_id") REFERENCES "patients" ("id");

ALTER TABLE "patients_family_medical_history" ADD FOREIGN KEY ("family_medical_history_patient_id") REFERENCES "family_medical_history" ("patient_id");


CREATE TABLE "habits_frequency_types" (
  "habits_frequency_type_id" integer,
  "frequency_types_id" integer,
  PRIMARY KEY ("habits_frequency_type_id", "frequency_types_id")
);

ALTER TABLE "habits_frequency_types" ADD FOREIGN KEY ("habits_frequency_type_id") REFERENCES "habits" ("frequency_type_id");

ALTER TABLE "habits_frequency_types" ADD FOREIGN KEY ("frequency_types_id") REFERENCES "frequency_types" ("id");


CREATE TABLE "treatments_Doses" (
  "treatments_dose_id" integer,
  "Doses_id" integer,
  PRIMARY KEY ("treatments_dose_id", "Doses_id")
);

ALTER TABLE "treatments_Doses" ADD FOREIGN KEY ("treatments_dose_id") REFERENCES "treatments" ("dose_id");

ALTER TABLE "treatments_Doses" ADD FOREIGN KEY ("Doses_id") REFERENCES "Doses" ("id");


CREATE TABLE "habits_Doses" (
  "habits_dose_id" integer,
  "Doses_id" integer,
  PRIMARY KEY ("habits_dose_id", "Doses_id")
);

ALTER TABLE "habits_Doses" ADD FOREIGN KEY ("habits_dose_id") REFERENCES "habits" ("dose_id");

ALTER TABLE "habits_Doses" ADD FOREIGN KEY ("Doses_id") REFERENCES "Doses" ("id");


CREATE TABLE "habits_alcohol_habits" (
  "habits_id" integer,
  "alcohol_habits_habit_id" integer,
  PRIMARY KEY ("habits_id", "alcohol_habits_habit_id")
);

ALTER TABLE "habits_alcohol_habits" ADD FOREIGN KEY ("habits_id") REFERENCES "habits" ("id");

ALTER TABLE "habits_alcohol_habits" ADD FOREIGN KEY ("alcohol_habits_habit_id") REFERENCES "alcohol_habits" ("habit_id");


CREATE TABLE "habits_physical_activity_habits" (
  "habits_id" integer,
  "physical_activity_habits_habit_id" integer,
  PRIMARY KEY ("habits_id", "physical_activity_habits_habit_id")
);

ALTER TABLE "habits_physical_activity_habits" ADD FOREIGN KEY ("habits_id") REFERENCES "habits" ("id");

ALTER TABLE "habits_physical_activity_habits" ADD FOREIGN KEY ("physical_activity_habits_habit_id") REFERENCES "physical_activity_habits" ("habit_id");


CREATE TABLE "habits_menstrual_cycle_habits" (
  "habits_id" integer,
  "menstrual_cycle_habits_habit_id" integer,
  PRIMARY KEY ("habits_id", "menstrual_cycle_habits_habit_id")
);

ALTER TABLE "habits_menstrual_cycle_habits" ADD FOREIGN KEY ("habits_id") REFERENCES "habits" ("id");

ALTER TABLE "habits_menstrual_cycle_habits" ADD FOREIGN KEY ("menstrual_cycle_habits_habit_id") REFERENCES "menstrual_cycle_habits" ("habit_id");


CREATE TABLE "habits_smoking_habits" (
  "habits_id" integer,
  "smoking_habits_habit_id" integer,
  PRIMARY KEY ("habits_id", "smoking_habits_habit_id")
);

ALTER TABLE "habits_smoking_habits" ADD FOREIGN KEY ("habits_id") REFERENCES "habits" ("id");

ALTER TABLE "habits_smoking_habits" ADD FOREIGN KEY ("smoking_habits_habit_id") REFERENCES "smoking_habits" ("habit_id");


CREATE TABLE "habits_sleep_habits" (
  "habits_id" integer,
  "sleep_habits_habit_id" integer,
  PRIMARY KEY ("habits_id", "sleep_habits_habit_id")
);

ALTER TABLE "habits_sleep_habits" ADD FOREIGN KEY ("habits_id") REFERENCES "habits" ("id");

ALTER TABLE "habits_sleep_habits" ADD FOREIGN KEY ("sleep_habits_habit_id") REFERENCES "sleep_habits" ("habit_id");


CREATE TABLE "habits_stress_habits" (
  "habits_id" integer,
  "stress_habits_habit_id" integer,
  PRIMARY KEY ("habits_id", "stress_habits_habit_id")
);

ALTER TABLE "habits_stress_habits" ADD FOREIGN KEY ("habits_id") REFERENCES "habits" ("id");

ALTER TABLE "habits_stress_habits" ADD FOREIGN KEY ("stress_habits_habit_id") REFERENCES "stress_habits" ("habit_id");


CREATE TABLE "habits_contraception_habits" (
  "habits_id" integer,
  "contraception_habits_habit_id" integer,
  PRIMARY KEY ("habits_id", "contraception_habits_habit_id")
);

ALTER TABLE "habits_contraception_habits" ADD FOREIGN KEY ("habits_id") REFERENCES "habits" ("id");

ALTER TABLE "habits_contraception_habits" ADD FOREIGN KEY ("contraception_habits_habit_id") REFERENCES "contraception_habits" ("habit_id");


CREATE TABLE "habits_mental_health_habits" (
  "habits_id" integer,
  "mental_health_habits_habit_id" integer,
  PRIMARY KEY ("habits_id", "mental_health_habits_habit_id")
);

ALTER TABLE "habits_mental_health_habits" ADD FOREIGN KEY ("habits_id") REFERENCES "habits" ("id");

ALTER TABLE "habits_mental_health_habits" ADD FOREIGN KEY ("mental_health_habits_habit_id") REFERENCES "mental_health_habits" ("habit_id");


CREATE TABLE "habits_diet_habits" (
  "habits_id" integer,
  "diet_habits_habit_id" integer,
  PRIMARY KEY ("habits_id", "diet_habits_habit_id")
);

ALTER TABLE "habits_diet_habits" ADD FOREIGN KEY ("habits_id") REFERENCES "habits" ("id");

ALTER TABLE "habits_diet_habits" ADD FOREIGN KEY ("diet_habits_habit_id") REFERENCES "diet_habits" ("habit_id");


CREATE TABLE "treatments_mental_health_habits" (
  "treatments_id" integer,
  "mental_health_habits_treatment_id" integer,
  PRIMARY KEY ("treatments_id", "mental_health_habits_treatment_id")
);

ALTER TABLE "treatments_mental_health_habits" ADD FOREIGN KEY ("treatments_id") REFERENCES "treatments" ("id");

ALTER TABLE "treatments_mental_health_habits" ADD FOREIGN KEY ("mental_health_habits_treatment_id") REFERENCES "mental_health_habits" ("treatment_id");


CREATE TABLE "Records_mental_health_records" (
  "Records_id" integer,
  "mental_health_records_record_id" integer,
  PRIMARY KEY ("Records_id", "mental_health_records_record_id")
);

ALTER TABLE "Records_mental_health_records" ADD FOREIGN KEY ("Records_id") REFERENCES "Records" ("id");

ALTER TABLE "Records_mental_health_records" ADD FOREIGN KEY ("mental_health_records_record_id") REFERENCES "mental_health_records" ("record_id");


CREATE TABLE "Records_menstruation_records" (
  "Records_id" integer,
  "menstruation_records_record_id" integer,
  PRIMARY KEY ("Records_id", "menstruation_records_record_id")
);

ALTER TABLE "Records_menstruation_records" ADD FOREIGN KEY ("Records_id") REFERENCES "Records" ("id");

ALTER TABLE "Records_menstruation_records" ADD FOREIGN KEY ("menstruation_records_record_id") REFERENCES "menstruation_records" ("record_id");


CREATE TABLE "Records_sleep_records" (
  "Records_id" integer,
  "sleep_records_record_id" integer,
  PRIMARY KEY ("Records_id", "sleep_records_record_id")
);

ALTER TABLE "Records_sleep_records" ADD FOREIGN KEY ("Records_id") REFERENCES "Records" ("id");

ALTER TABLE "Records_sleep_records" ADD FOREIGN KEY ("sleep_records_record_id") REFERENCES "sleep_records" ("record_id");


CREATE TABLE "Records_stress_records" (
  "Records_id" integer,
  "stress_records_record_id" integer,
  PRIMARY KEY ("Records_id", "stress_records_record_id")
);

ALTER TABLE "Records_stress_records" ADD FOREIGN KEY ("Records_id") REFERENCES "Records" ("id");

ALTER TABLE "Records_stress_records" ADD FOREIGN KEY ("stress_records_record_id") REFERENCES "stress_records" ("record_id");

