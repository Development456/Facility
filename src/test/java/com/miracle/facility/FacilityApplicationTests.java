package com.miracle.facility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.miracle.facility.entity.Facility;
import com.miracle.facility.repository.FacilityRepository;
import com.miracle.facility.service.FacilityServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class FacilityApplicationTests {
	
	@Autowired
	FacilityServiceImpl service;
	
	@MockBean
	FacilityRepository repository;
	
	
		
	//get all facility test
	@Test
	public void getAllFacilityTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Facility("63b7d6082a5a482e7e1507e6", "IL91004", "734 Mccormick Hill", "410", "", "Sterling", "Kuhlman Group", "20167", "VA", "United States", "571-645-4741", "Nertie Freeman", "Port Facility", "30-Jan-2020")).collect(Collectors.toList()));
	}
		
	//get by facilityId test
	@Test
	public void getByIdTest() {
		String city = "Anaheim";
		when(repository.getFacilityByCity(city)).thenReturn((List<Facility>) Stream
				.of(new Facility("63b7d6082a5a482e7e1507e6", "IL91004", "734 Mccormick Hill", "410", "", "Sterling", "Kuhlman Group", "20167", "VA", "United States", "571-645-4741", "Nertie Freeman", "Port Facility", "30-Jan-2020")).collect(Collectors.toList()));
		assertEquals("Sterling", service.getFacilityByCity(city).get(0).getCity());	
	}
	
	//test to get facility by city
	@Test
	public void getFacilityByCityTest() {
		String city = "Anaheim";
		when(repository.getFacilityByCity(city)).thenReturn((List<Facility>) Stream
				.of(new Facility("63b7d6082a5a482e7e1507e6", "IL91004", "734 Mccormick Hill", "410", "", "Sterling", "Kuhlman Group", "20167", "VA", "United States", "571-645-4741", "Nertie Freeman", "Port Facility", "30-Jan-2020")).collect(Collectors.toList()));
		assertEquals("Sterling", service.getFacilityByCity(city).get(0).getCity());
	}
	
	//test to get facility by name
	@Test
	public void getFacilityByNameTest() {
		String facilityName = "Anaheim, CA (PWR)";
		when(repository.getFacilityByName(facilityName)).thenReturn((List<Facility>) Stream
				.of(new Facility("63b7d6082a5a482e7e1507e6", "IL91004", "734 Mccormick Hill", "410", "", "Sterling", "Kuhlman Group", "20167", "VA", "United States", "571-645-4741", "Nertie Freeman", "Port Facility", "30-Jan-2020")).collect(Collectors.toList()));
		assertEquals("Kuhlman Group", service.getFacilityByName(facilityName).get(0).getFacilityName());
				
	}
	
	//test to get facility by postal code
	@Test
	public void getFacilityByCodeTest() {
		String postalCode = "92801";
		when(repository.getFacilityByPostalCode(postalCode)).thenReturn((List<Facility>) Stream
				.of(new Facility("63b7d6082a5a482e7e1507e6", "IL91004", "734 Mccormick Hill", "410", "", "Sterling", "Kuhlman Group", "20167", "VA", "United States", "571-645-4741", "Nertie Freeman", "Port Facility", "30-Jan-2020")).collect(Collectors.toList()));
		assertEquals("20167", service.getFacilityByCode(postalCode).get(0).getPostalCode());
	}
	
	//test to get facility by state 
	@Test
	public void getFacilityByStateTest() {
		String facilityState = "CA";
		when(repository.getFacilityByState(facilityState)).thenReturn((List<Facility>) Stream
				.of(new Facility("63b7d6082a5a482e7e1507e6", "IL91004", "734 Mccormick Hill", "410", "", "Sterling", "Kuhlman Group", "20167", "VA", "United States", "571-645-4741", "Nertie Freeman", "Port Facility", "30-Jan-2020")).collect(Collectors.toList()));
		assertEquals("VA", service.getFacilityByState(facilityState).get(0).getState());
	}
	
	//test to get facility by country
	@Test
	public void getFacilityByCountryTest() {
		String facilityCountry = "United States";
		when(repository.getFacilityByCountry(facilityCountry)).thenReturn((List<Facility>) Stream
				.of(new Facility("63b7d6082a5a482e7e1507e6", "IL91004", "734 Mccormick Hill", "410", "", "Sterling", "Kuhlman Group", "20167", "VA", "United States", "571-645-4741", "Nertie Freeman", "Port Facility", "30-Jan-2020")).collect(Collectors.toList()));
		assertEquals("United States", service.getFacilityByCountry(facilityCountry).get(0).getCountry());
	}
	
	//test to get facility by Phone
	@Test
	public void getFacilityByPhoneTest() {
		String facilityPhone = "(714) 449-2880";
		when(repository.getFacilityByPhone(facilityPhone)).thenReturn((List<Facility>) Stream
				.of(new Facility("63b7d6082a5a482e7e1507e6", "IL91004", "734 Mccormick Hill", "410", "", "Sterling", "Kuhlman Group", "20167", "VA", "United States", "571-645-4741", "Nertie Freeman", "Port Facility", "30-Jan-2020")).collect(Collectors.toList()));
		assertEquals("571-645-4741", service.getFacilityByPhone(facilityPhone).get(0).getPhone());
	}
	
	//test get the list of facility by manager
	@Test
	public void getFacilityByFacilityManagerTest() {
		String facilityManager = "Giff Leynagh";
		when(repository.getFacilityByManager(facilityManager)).thenReturn((List<Facility>) Stream
				.of(new Facility("63b7d6082a5a482e7e1507e6", "IL91004", "734 Mccormick Hill", "410", "", "Sterling", "Kuhlman Group", "20167", "VA", "United States", "571-645-4741", "Nertie Freeman", "Port Facility", "30-Jan-2020")).collect(Collectors.toList()));
		assertEquals("Nertie Freeman", service.getFacilityByFacilityManager(facilityManager).get(0).getFacilityManager());
	}
	
	//test to get list by category
	@Test
	public void getFacilityByCategoryTest() {
		String facilityCategory= "SQF Certified";
		when(repository.getFacilityByCategory(facilityCategory)).thenReturn((List<Facility>) Stream
				.of(new Facility("63b7d6082a5a482e7e1507e6", "IL91004", "734 Mccormick Hill", "410", "", "Sterling", "Kuhlman Group", "20167", "VA", "United States", "571-645-4741", "Nertie Freeman", "Port Facility", "30-Jan-2020")).collect(Collectors.toList()));
		assertEquals("Port Facility", service.getFacilityByCategory(facilityCategory).get(0).getCategory());
	}
	
	
	//post
	@Test
	public void addNewFacilityTest() {
		Facility facility = new Facility();
		when(repository.save(facility)).thenReturn(facility);
		try {
			assertEquals(facility, service.addNewFacility(facility));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//delete
	@Test
	public void deleteFacilityTest() {
		String FacilityId = "LAA00000";
		service.deleteFacility(FacilityId);
		verify(repository, times(1)).deleteByFacilityId(FacilityId);
	}
	
	
	@Test
	public void testUpdate () {
		Facility facility = new Facility();
		facility.setFacilityId("LAA000001");
		facility.setAddressLine1("410");
		facility.setAddressLine2("734 Mccormick Hill");
		facility.setAddressLine3("");
		facility.setCity("Duluth");
		facility.setFacilityName("Kuhlman Group");
		facility.setPostalCode("20167");
		facility.setState("GA");
		facility.setCountry("USA");
		facility.setPhone("571-645-4741");
		facility.setFacilityManager("Nertie Freeman");
		facility.setCategory("Port Facility");		
		repository.save(facility);
		
		assertEquals("LAA000001", facility.getFacilityId());
		assertEquals("410", facility.getAddressLine1());
		assertEquals("734 Mccormick Hill", facility.getAddressLine2());
		assertEquals("", facility.getAddressLine3());
		assertEquals("Duluth", facility.getCity());
		assertEquals("Kuhlman Group", facility.getFacilityName());
		assertEquals("20167", facility.getPostalCode());
		assertEquals("GA", facility.getState());
		assertEquals("USA", facility.getCountry());
		assertEquals("571-645-4741", facility.getPhone());
		assertEquals("Nertie Freeman", facility.getFacilityManager());
		assertEquals("Port Facility", facility.getCategory());
	}
}
