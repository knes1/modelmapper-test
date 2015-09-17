package io.github.knes1.modelmappertest;

import org.junit.Assert;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**
 * @author knesek
 * Created on: 17/09/15
 */
public class ModelMapperTest {

	@Test
	public void testModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new TestDTOMapping());
		Model model = new Model();
		modelMapper.map(new ModelDto("test"), model);
		Assert.assertEquals("test", model.getTest());
	}

	public static class Model implements Comparable<Model> {
		private String test;

		public String getTest() {
			return test;
		}

		public void setTest(String test) {
			this.test = test;
		}

		@Override
		public int compareTo(Model o) {
			return test.compareTo(o.test);
		}
	}

	public static class ModelDto {
		private String testDTO;

		public ModelDto(String testDTO) {
			this.testDTO = testDTO;
		}

		public String getTestDTO() {
			return testDTO;
		}

		public void setTestDTO(String testDTO) {
			this.testDTO = testDTO;
		}
	}

	public static class TestDTOMapping extends PropertyMap<ModelDto, Model> {

		@Override
		protected void configure() {
			map(source.getTestDTO(), destination.getTest());
		}

	}

}
