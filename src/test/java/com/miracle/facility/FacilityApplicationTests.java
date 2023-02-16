package com.miracle.facility;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.core.MediaType;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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
	
	@Autowired
	FacilityRepository facilityRepository;
	
	
	//need to write PUT, filter, kafka method's test
	
	//get all facility test
	@Test
	public void getAllFacilityTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Facility("63b7d6082a5a482e7e1507e6", "IL91004", "734 Mccormick Hill", "410", "", "Sterling", "Kuhlman Group", "20167", "VA", "United States", "571-645-4741", "Nertie Freeman", "Port Facility", "30-Jan-2020")).collect(Collectors.toList()));
	}
		
	//failing
	//get by facilityId test
	@Test
	public void getByIdTest() {
		String city = "Anaheim";
		when(repository.getFacilityByCity(city)).thenReturn((List<Facility>) Stream
				.of(new Facility("63b7d6082a5a482e7e1507e6", "IL91004", "734 Mccormick Hill", "410", "", "Sterling", "Kuhlman Group", "20167", "VA", "United States", "571-645-4741", "Nertie Freeman", "Port Facility", "30-Jan-2020")).collect(Collectors.toList()));
		assertEquals("Sterling", service.getFacilityByCity(city).get(0).getCity());
//		String facilityId = "LAA00000";
//		when(repository.findByFacilityId(facilityId)).thenReturn((Facility) Stream
//				.of(new Facility("63b7d6082a5a482e7e1507e6", "IL91004", "734 Mccormick Hill", "410", "", "Sterling", "Kuhlman Group", "20167", "VA", "United States", "571-645-4741", "Nertie Freeman", "Port Facility", "30-Jan-2020")).collect(Collectors.toList()));
//		assertEquals("IL91004", repository.findByFacilityId(facilityId).getFacilityId());
//		
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
	
	
//	public Facility updateFacility(String facilityId, Facility facility) {
//		try {
//			Facility facilities = facilityRepository.findByFacilityId(facilityId);
//
//			System.out.println("the id is" + facilities.getAddressLine1());
//
//			facilities.setAddressLine1(facility.getAddressLine1());
//			facilities.setAddressLine2(facility.getAddressLine2());
//			facilities.setAddressLine3(facility.getAddressLine3());
//			facilities.setCity(facility.getCity());
//			facilities.setFacilityName(facility.getFacilityName());
	
//			facilities.setPostalCode(facility.getPostalCode());
//			facilities.setState(facility.getState());
//			facilities.setCountry(facility.getCountry());
//			facilities.setPhone(facility.getPhone());
//			facilities.setFacilityManager(facility.getFacilityManager());
//			facilities.setCategory(facility.getCategory());
//			facilityRepository.save(facilities);
//
//			return facilities;
//		} catch (Exception e) {
//			return facility ;
//		}
	
	
//	@Test
//    @Order(4)
//    @Rollback(value = false)
//    public void updateEmployeeTest(){
//        Employee employee = employeeRepository.findById(1L).get();
//        employee.setEmail("ram@gmail.com");
//        Employee employeeUpdated =  employeeRepository.save(employee);
//        Assertions.assertThat(employeeUpdated.getEmail()).isEqualTo("ram@gmail.com");
//    }
	
//	put
//	@Test
//	public void updateFacilityTest() throws Exception{
//		
//		String fac = "MDC00000";
//		List<Facility> facility = service.getById(fac);
//		System.out.println(facility);
//		
//		facility.get(0).setAddressLine1("2650");
//		facility.get(0).setAddressLine2("College Place");
//		facility.get(0).setAddressLine3("address 3");
//		facility.get(0).setCity("Fullerton");
//		facility.get(0).setFacilityName("FacilityName");
//		facility.get(0).setPostalCode("30097");
//		facility.get(0).setState("CA");
//		facility.get(0).setCountry("USA");
//		facility.get(0).setPhone("Phone");
//		facility.get(0).setFacilityManager("FManager");
//		facility.get(0).setCategory("category");
//		
//		Facility updatedFacility = service.addNewFacility(facility.get(0));
//		Assertions.assertThat(updatedFacility.getAddressLine1()).isEqualTo("2650");
//		Assertions.assertThat(updatedFacility.getAddressLine2()).isEqualTo("College Place");
//		Assertions.assertThat(updatedFacility.getAddressLine3()).isEqualTo("address 3");
//		Assertions.assertThat(updatedFacility.getCity()).isEqualTo("Fullerton");
//		Assertions.assertThat(updatedFacility.getFacilityName()).isEqualTo("FacilityName");
//		Assertions.assertThat(updatedFacility.getPostalCode()).isEqualTo("30097");
//		Assertions.assertThat(updatedFacility.getState()).isEqualTo("CA");
//		Assertions.assertThat(updatedFacility.getCountry()).isEqualTo("USA");
//		Assertions.assertThat(updatedFacility.getPhone()).isEqualTo("Phone");
//		Assertions.assertThat(updatedFacility.getFacilityManager()).isEqualTo("FManager");
//		Assertions.assertThat(updatedFacility.getCategory()).isEqualTo("category");		
//    }
		
	
	
	
//	@Test
//	@Order(1)
//	public void testCreate () {
//	Product p = new Product();
//	p.setId(1L);
//	p.setName("iPhone XR");
//	p.setDesc("Fantastic");
//	p.setPrice(1000.00);
//	pRepo.save(p);
//	assertNotNull(pRepo.findById(1L).get());
//	}
}





















	
