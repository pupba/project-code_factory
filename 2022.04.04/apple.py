# apple class
# apple's element
##  color, shape, fresh, stalk, scratch
class Apple :
    def __init__(self,color,shape,fresh,stalk,scratch):
        self.color = color # A 95 ,B(85~94), C(75~84) D(0~74)
        self.shape = shape # Vgood, good, bad
        self.fresh = fresh # Vgood, good, bad
        self.stalk = stalk # True, False
        self.scratch = scratch # none, little, many
    
    def Rating(self):
        Rating = "none"
        if 95 <= self.color : # color
            if self.shape == "Vgood" : # shape
                if self.fresh == "Vgood": # fresh
                    if self.stalk: # stalk
                        if self.scratch == "none" : # scratch
                            Rating = "A"
                        elif self.scratch == "little" : # scratch
                            Rating = "B"
                        elif self.scratch == "many": # scratch
                            Rating = "C"
                    else : # stalk
                        if self.scratch == "none" : # scratch
                            Rating = "B"
                        elif self.scratch == "little" : # scratch
                            Rating = "C"
                        elif self.scratch == "many": # scratch
                            Rating = "D"
                elif self.fresh == "good": # fresh
                    if self.stalk: # stalk
                        if self.scratch == "none" : # scratch
                            Rating = "B"
                        elif self.scratch == "little" : # scratch
                            Rating = "C"
                        elif self.scratch == "many": # scratch
                            Rating = "D"
                    else : # stalk
                        if self.scratch == "none" : # scratch
                            Rating = "B"
                        elif self.scratch == "little" : # scratch
                            Rating = "C"
                        elif self.scratch == "many": # scratch
                            Rating = "D"
                elif self.fresh == "bad": # fresh
                    Rating = "D"
            elif self.shape == "good" : # shape
                if self.fresh == "Vgood": # fresh
                    if self.stalk: # stalk
                        if self.scratch == "none" : # scratch
                            Rating = "B"
                        elif self.scratch == "little" : # scratch
                            Rating = "C"
                        elif self.scratch == "many": # scratch
                            Rating = "D"
                    else : # stalk
                        if self.scratch == "none" : # scratch
                            Rating = "B"
                        elif self.scratch == "little" : # scratch
                            Rating = "C"
                        elif self.scratch == "many": # scratch
                            Rating = "D"
                elif self.fresh == "good": # fresh
                    if self.stalk: # stalk
                        if self.scratch == "none" : # scratch
                            Rating = "B"
                        elif self.scratch == "little" : # scratch
                            Rating = "C"
                        elif self.scratch == "many": # scratch
                            Rating = "D"
                    else : # stalk
                        if self.scratch == "none" : # scratch
                            Rating = "B"
                        elif self.scratch == "little" : # scratch
                            Rating = "C"
                        elif self.scratch == "many": # scratch
                            Rating = "D"
                elif self.fresh == "bad": # fresh
                    Rating = "D"
            elif self.shape == "bad" : # shape
                Rating = "D"
        elif 85 <= self.color and self.color < 95 : # color
            if self.shape == "Vgood" : # shape
                if self.fresh == "Vgood": # fresh
                    if self.stalk: # stalk
                        if self.scratch == "none" : # scratch
                            Rating = "B"
                        elif self.scratch == "little" : # scratch
                            Rating = "C"
                        elif self.scratch == "many": # scratch
                            Rating = "D"
                    else : # stalk
                        if self.scratch == "none" : # scratch
                            Rating = "B"
                        elif self.scratch == "little" : # scratch
                            Rating = "C"
                        elif self.scratch == "many": # scratch
                            Rating = "D"
                elif self.fresh == "good": # fresh
                    if self.stalk: # stalk
                        if self.scratch == "none" : # scratch
                            Rating = "C"
                        elif self.scratch == "little" : # scratch
                            Rating = "C"
                        elif self.scratch == "many": # scratch
                            Rating = "D"
                    else : # stalk
                        Rating = "D"
                elif self.fresh == "bad": # fresh
                    Rating = "D"
            elif self.shape == "good" : # shape
                if self.fresh == "Vgood": # fresh
                    if self.stalk: # stalk
                        if self.scratch == "none" : # scratch
                            Rating = "B"
                        elif self.scratch == "little" : # scratch
                            Rating = "C"
                        elif self.scratch == "many": # scratch
                            Rating = "D"
                    else : # stalk
                        if self.scratch == "none" : # scratch
                            Rating = "B"
                        elif self.scratch == "little" : # scratch
                            Rating = "C"
                        elif self.scratch == "many": # scratch
                            Rating = "D"
                elif self.fresh == "good": # fresh
                    if self.stalk: # stalk
                        if self.scratch == "none" : # scratch
                            Rating = "C"
                        elif self.scratch == "little" : # scratch
                            Rating = "D"
                        elif self.scratch == "many": # scratch
                            Rating = "D"
                    else : # stalk
                        Rating = "D"
                elif self.fresh == "bad": # fresh
                    Rating = "D"
            elif self.shape == "bad" : # shape
                Rating = "D"
        elif 75 <= self.color and self.color < 85: # color
            if self.shape == "Vgood" : # shape
                if self.fresh == "Vgood": # fresh
                    if self.stalk: # stalk
                        if self.scratch == "none" : # scratch
                            Rating = "C"
                        elif self.scratch == "little" : # scratch
                            Rating = "D"
                        elif self.scratch == "many": # scratch
                            Rating = "D"
                    else : # stalk
                        Rating = "D"
                elif self.fresh == "good": # fresh
                    Rating = "D"
                elif self.fresh == "bad": # fresh
                    Rating = "D"
            elif self.shape == "good" : # shape
                if self.fresh == "Vgood": # fresh
                    if self.stalk: # stalk
                        if self.scratch == "none" : # scratch
                            Rating = "C"
                        elif self.scratch == "little" : # scratch
                            Rating = "D"
                        elif self.scratch == "many": # scratch
                            Rating = "D"
                    else : # stalk
                        Rating = "D"
                elif self.fresh == "good": # fresh
                    Rating = "D"
                elif self.fresh == "bad": # fresh
                    Rating = "D"
            elif self.shape == "bad" : # shape
                Rating = "D"
        else : # color
            Rating = "D"
        return Rating
    

apple1 = Apple(95,"Vgood","Vgood",True,"none")
print("{}의 Rating = \'{}\'".format("apple1",apple1.Rating()))