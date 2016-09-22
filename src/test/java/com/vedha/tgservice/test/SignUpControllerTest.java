package com.vedha.tgservice.test;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import com.vedha.tech.common.constants.ActionMode;
import com.vedha.tech.common.dto.BasicDTO;
import com.vedha.tech.common.variable.AppDate;
import com.vedha.tgservice.RestApplication;
import com.vedha.tgservice.constants.AppConstants;
import com.vedha.tgservice.dto.SignUpDTO;
import com.vedha.tgservice.repository.SignUpRepository;
import com.vedha.tgservice.service.SignUpService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestApplication.class)
@WebAppConfiguration
public class SignUpControllerTest {
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    @SuppressWarnings("rawtypes")
	private HttpMessageConverter mappingJackson2HttpMessageConverter;
    
    private SignUpDTO signUpDTO;

    private List<SignUpDTO> custCommonList = new ArrayList<SignUpDTO>();
    
    @Autowired
    private SignUpService signUpService;
    
    @Autowired
    private SignUpRepository signUpRepository;
    
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

    for (HttpMessageConverter<?> httpMessageConverter : converters) {
			if (httpMessageConverter instanceof MappingJackson2HttpMessageConverter) {
				this.mappingJackson2HttpMessageConverter = httpMessageConverter;
			}
		}

        Assert.assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }
    
    @Before
    public void setup() throws Exception {
    	//Date date=new Date();
    	//long datetime=date.getTime();
    	//String strLong = Long.toString(datetime);
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
      //delete previous data from table
        this.signUpRepository.deleteAllInBatch();

        signUpDTO = new SignUpDTO();
        signUpDTO.setCustID((long) 1111);
        signUpDTO.setCustType('T');
        signUpDTO.setEmail("xxx@gmail.com");
        signUpDTO.setPassword("xxx");
        signUpDTO.setFirstName("xx");
        signUpDTO.setLastName("yy");
        signUpDTO.setCountryCode(111);
        signUpDTO.setPhoneNum((long)1234567890);
     
        
        fillDefaultValue(signUpDTO, ActionMode.CREATE);
        this.signUpDTO = signUpService.add(signUpDTO);
               
        signUpDTO = new SignUpDTO();
        signUpDTO.setCustID((long) 2222);
        signUpDTO.setCustType('S');
        signUpDTO.setEmail("yyy@gmail.com");
        signUpDTO.setPassword("yyy");
        signUpDTO.setFirstName("yy");
        signUpDTO.setLastName("yy");
        signUpDTO.setCountryCode(222);
        signUpDTO.setPhoneNum((long)1764567890);
        
        fillDefaultValue(signUpDTO, ActionMode.CREATE);
        this.signUpDTO = signUpService.add(signUpDTO);
        
        custCommonList = signUpService.getAll();
    }
    
    @Test
    public void readSingleUser() throws Exception {
    	SignUpDTO checkUser = custCommonList.get(0);
        mockMvc.perform(get("/signup/getByID/"+ this.custCommonList.get(0).getCustID()))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.custID", is(checkUser.getCustID().intValue())))
                .andExpect(jsonPath("$.custType", is(checkUser.getCustType().toString())))
                .andExpect(jsonPath("$.email", is(checkUser.getEmail())))
        		.andExpect(jsonPath("$.password", is(checkUser.getPassword())))
        		.andExpect(jsonPath("$.firstName", is(checkUser.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(checkUser.getLastName())))
                .andExpect(jsonPath("$.countryCode", is(checkUser.getCountryCode())))
                .andExpect(jsonPath("$.phoneNum", is(checkUser.getPhoneNum().intValue())));
              
                
    }
    
    @Test
    public void readAllUsers() throws Exception {
    	SignUpDTO checkUser1 = custCommonList.get(0);
    	SignUpDTO checkUser2= custCommonList.get(1);
    	
     	 MvcResult rs =  mockMvc.perform(get("/signup/getAll/")).andReturn();
    	// System.out.println(">>>>>>>>>>user/getAll>>>>>>>>>>>"+ new String(rs.getResponse().getContentAsByteArray()));
    	
    	 mockMvc.perform(get("/signup/getAll/"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$[0].custID", is(checkUser1.getCustID().intValue())))
        .andExpect(jsonPath("$[0].custType", is(checkUser1.getCustType().toString())))
        .andExpect(jsonPath("$[0].email", is(checkUser1.getEmail())))
		.andExpect(jsonPath("$[0].password", is(checkUser1.getPassword())))
		.andExpect(jsonPath("$[0].firstName", is(checkUser1.getFirstName())))
        .andExpect(jsonPath("$[0].lastName", is(checkUser1.getLastName())))
        .andExpect(jsonPath("$[0].countryCode", is(checkUser1.getCountryCode())))
        .andExpect(jsonPath("$[0].phoneNum", is(checkUser1.getPhoneNum().intValue())))
    	.andExpect(jsonPath("$[1].custID", is(checkUser2.getCustID().intValue())))
        .andExpect(jsonPath("$[1].custType", is(checkUser2.getCustType().toString())))
        .andExpect(jsonPath("$[1].email", is(checkUser2.getEmail())))
		.andExpect(jsonPath("$[1].password", is(checkUser2.getPassword())))
		.andExpect(jsonPath("$[1].firstName", is(checkUser2.getFirstName())))
        .andExpect(jsonPath("$[1].lastName", is(checkUser2.getLastName())))
        .andExpect(jsonPath("$[1].countryCode", is(checkUser2.getCountryCode())))
        .andExpect(jsonPath("$[1].phoneNum", is(checkUser2.getPhoneNum().intValue())));
    }
    
   // @Test
    public void createNewUser() throws Exception {
    	
    	SignUpDTO signUpDTO = new SignUpDTO();
    	signUpDTO = new SignUpDTO();
        signUpDTO.setCustID((long) 333);
        signUpDTO.setCustType('T');
        signUpDTO.setEmail("zzz@gmail.com");
        signUpDTO.setPassword("zzz");
        signUpDTO.setFirstName("zz");
        signUpDTO.setLastName("zz");
        signUpDTO.setCountryCode(333);
        signUpDTO.setPhoneNum((long)888377516);
    	        
        String userJson = json(signUpDTO);
        this.mockMvc.perform(post("/signup/add")
                .contentType(contentType)
                .content(userJson))
                .andExpect(status().isCreated());
    }
    
   /* @Test
    public void modifyUser() throws Exception {
    	
    	CustCommonDTO editUser = custCommonService.getUserByID(custCommonList.get(0).getCustID());
    	
    	String editCommon =  editUser.getCustID() + " Edit";
    	editUser.setCustID(editCommon);
    	
    	
        String editUserJson = json(editCommon);
        this.mockMvc.perform(post("/user/modifyCommon")
                .contentType(contentType)
                .content(editUserJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.custID", is(editCommon)));
    }
    */
    @Test
    public void deleteUser() throws Exception {
    	
    	SignUpDTO deleteUser = signUpService.getByID(custCommonList.get(0).getCustID());
    	
    	this.mockMvc.perform(get("/signup/delete/"+deleteUser.getCustID()))
                .andExpect(status().isOk());
        
        mockMvc.perform(get("/signup/getByID/"+ deleteUser.getCustID()))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
               
    }

    @SuppressWarnings("unchecked")
  	protected String json(Object o) throws IOException {
          MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
          this.mappingJackson2HttpMessageConverter.write(o, contentType, mockHttpOutputMessage);
          //(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
          return mockHttpOutputMessage.getBodyAsString();
      }

private void fillDefaultValue(BasicDTO dto, ActionMode action) {
		
		switch (action) {
		case CREATE:
			dto.setActionMode(action);
			dto.setCreatedBy("Test");
			dto.setCreationDate(new AppDate(System.currentTimeMillis()));
			dto.setRcdStatus("A");
			dto.setReasonCode("NONE");
			dto.setVersionNum(AppConstants.VERSION_ONE);
			break;

		case MODIFY:
			dto.setActionMode(action);
			dto.setCreatedBy("Test");
			dto.setModificationDate(new AppDate(System.currentTimeMillis()));
			dto.setRcdStatus("A");
			dto.setReasonCode("NONE");
			dto.setVersionNum(dto.getVersionNum() + AppConstants.VERSION_ONE);
			break;

		case DELETE:
			dto.setActionMode(action);
			dto.setCreatedBy("Test");
			dto.setModificationDate(new AppDate(System.currentTimeMillis()));
			dto.setRcdStatus("D");
			dto.setReasonCode("NONE");
			dto.setVersionNum(dto.getVersionNum() + AppConstants.VERSION_ONE);
			break;

		case VALIDATE:
			break;

		default:
			break;
		}
	}
}
