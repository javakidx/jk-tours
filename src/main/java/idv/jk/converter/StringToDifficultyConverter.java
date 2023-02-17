package idv.jk.converter;

import idv.jk.model.Difficulty;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class StringToDifficultyConverter implements Converter<String, Difficulty> {
    @Override
    public Difficulty convert(String value) {
        return StringUtils.isBlank(value)
                ? null
                : EnumUtils.getEnum(Difficulty.class, value.toUpperCase());
    }
}
