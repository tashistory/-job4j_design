create view show_all_patients
 as select m_h.c_date "дата",
p.name "Ф.И.О пациента", 
h_g.name "Группа здоровья", 
h.name "Мед. учереждение", 
d.name "Ф.И.О врача",
m_h.diagnosis "Диагноз", 
m_h.anamnis "Анамниз",
a.name "Анализ",
h_a.c_date "Дата анализа",
h_a.conclusion "Заключение",
r.id "Номер рецепта",
dr.name "Препорат"
from medical_historyes m_h
join hospitals h on m_h.id_hospital = h.id
join patients p on m_h.id_patient = p.id
left join health_groups h_g on p.id_helthe_group = h_g.id
join doctors d on m_h.id_doctors = d.id
left join historyes_analises h_a on  m_h.id = h_a.id_history
left join analises a on h_a.id_analise = a.id
left join recepts r on m_h.id = r.id_history
left join drugs dr on r.id_drug = dr.id;

