//
//  ViewController.swift
//  0715_Image
//
//  Created by TJ on 2021/07/15.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var imgTitle: UILabel!
    @IBOutlet weak var imgView: UIImageView!
    
    
    @IBOutlet weak var btnPrev: UIButton!
    @IBOutlet weak var btnNext: UIButton!
    
    
    var numImage = 0
    var imageName = ["flower_01.png", "flower_02.png", "flower_03.png", "flower_04.png", "flower_05.png", "flower_06.png"]
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        imgTitle.text = imageName[numImage]
        imgView.image = UIImage(named: imageName[numImage])
    }

    
    @IBAction func btnPrev(_ sender: UIButton) {
        if numImage < 6{
            numImage -= 1
            imgTitle.text = imageName[numImage]
            imgView.image = UIImage(named: imageName[numImage])
        }else if numImage == 0{
            imgTitle.text = imageName[numImage]
            imgView.image = UIImage(named: imageName[numImage])
        }
        
    }
    
    @IBAction func btnNext(_ sender: UIButton) {
        if numImage < imageName.count{
            // btnNext.isEnabled = true
            numImage += 1
            print(numImage, imageName[numImage])
            imgTitle.text = imageName[numImage]
            imgView.image = UIImage(named: imageName[numImage])
        }else if numImage == 5{
            // btnNext.isEnabled = false
            imgTitle.text = imageName[numImage]
            imgView.image = UIImage(named: imageName[numImage])
            
        }
    }
    
    
} // ViewController

