File.open("theros yml", "w") do |output|
	File.open("theros spoiler") do |file|
		output << "cards:\n"
		name = "";
		color = "";
		skip = false;
		type = "";
		rarity = "";

		file.each do |line|

			if line.start_with? "Name"
				skip = false;
				name = line.split(%r{\t})[1].strip.split(%r{[ ]}).each{|word| word.downcase!};
				if name[-1].start_with?('(') then
					name[-1] = name[-1].delete('()')
					if name[0] == name[-1] then
						skip = true;
						next
					end
					name.pop()
				end
				p name = name.join(" ")
			end

			if line.start_with? "Cost:"
				color = "";
				line.split("").each{ |char| if char[/[WUBGR]/] and !color.include? char then color << char end};
				p color
			end

			if line.start_with? "Type:"
				type = line.split(":")[1].strip.delete("—").split.join(" ");
				p type
			end

			if line.start_with?("Set/Rarity:") and skip == false
				rarity = line.split(" ")
				if rarity[-2] == "Mythic"
					rarity = rarity[-2] + " " + rarity[-1]
				else
					rarity = rarity[-1]
				end
				output << "  - !!models.Card\n"
				output << "    name:   " + name + "\n"
				output << "    colors: " + color + "\n"
				output << "    type:   " + type + "\n"
				output << "    set:    m14\n"
				output << "    rarity: " + rarity + "\n"
				output << "\n"
			end
		end
	end
end

