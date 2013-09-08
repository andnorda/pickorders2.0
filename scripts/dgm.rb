name = "";
skip = false;
File.open("m14 yml", "w") do |output|
  File.open("m14 spoiler") do |file|
	output << "cards:\n"
    file.each do |line|
    
      if line.start_with? "Name"
		skip = false;
        name = line.split(%r{\t})[1].strip.split(%r{[ ]});
        if name[-1].start_with?('(') then
        	name[-1] = name[-1].delete('()')
        	if name[0] == name[-1] then
        		skip = true;
        		next
        	end
        	name.pop()
        end
        p name.join(" ")
      end

      if line.start_with? "Cost:"
        color = ""
        line.split("").each{ |char| if char[/[WUBGR]/] and !color.include? char then color << char end};
		p color
      end

      if line.start_with?("Set/Rarity:") and skip == false
		output << "  - !!models.Card\n"
      end
    end
  end
end
